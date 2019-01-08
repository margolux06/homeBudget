import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {CyclicTransactionService} from "../transactions/services/cyclic-transaction.service";
import {CyclicTransactionDto} from "../transactions/models/CyclicTransactionDto";
import {ActivatedRoute} from "@angular/router";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {Observable, Subject, Subscription} from "rxjs";
import {ErrorStateMatcher} from "@angular/material";
import {FormControl, FormGroupDirective, NgForm} from "@angular/forms";
import {CyclicCostPeriod} from "../transactions/models/CyclicCostPeriod";
import {CyclicTransactionPeriodService} from "../transactions/services/cyclic-transaction-period.service";

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'cyclic-transaction-modify',
  templateUrl: './cyclic-transaction-modify.component.html',
  styleUrls: ['./cyclic-transaction-modify.component.css']
})
export class CyclicTransactionModifyComponent implements OnInit {
  private transactionSubscription: Subscription;
  private accoutSubscription: Subscription;

  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  periods: CyclicCostPeriod[] = [];
  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  transaction: CyclicTransactionDto = new CyclicTransactionDto();
  matcher: MyErrorStateMatcher;

  accountAssigned: boolean = false;

  constructor(private cyclicTransactionService: CyclicTransactionService,
              private bankAccountService: BankAccountService,
              private transactionPeriodsService: CyclicTransactionPeriodService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit() {
    this.fetchTransactionPeriods();
    this.fetchAccounts();

  }

  private loadCyclicTransaction() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = this.route.snapshot.paramMap.get("id");

      this.transactionSubscription = this.cyclicTransactionService.findAccountById(id)
        .subscribe(cyclicTransaction => {
          this.transaction = cyclicTransaction.get();
          this.accountAssigned = this.transaction.bankAccountId != null;
          console.log(this.transaction);
        }, error1 => {
          //  todo:
        })
    }
  }

  private fetchTransactionPeriods() {
    this.transactionPeriodsService.findAll().subscribe(
      transactionPeriods => {
        this.periods = transactionPeriods;
      }, error1 => {
        //todo:
      })
  }

  private fetchAccounts() {
    this.accoutSubscription = this.bankAccountService.getAccounts()
      .subscribe(accounts => {
        this.bankAccounts.next(accounts);
        this.loadCyclicTransaction();
      }, error1 => {
        console.log("fetchAccounts error" + error1);
      })
  }

  onSubmit() {
    console.log(this.transaction);
    let observable: Observable<any> =
      this.transaction.id == null ?
        this.cyclicTransactionService.save(this.transaction)
        : this.cyclicTransactionService.update(this.transaction);

    observable.subscribe(
      value => {
        this.location.back();
      }, error1 => {
        console.log("onSubmit error : " + error1);
      });
  }

  changedBindToBankAccount() {
    this.accountAssigned = !this.accountAssigned;

    if (this.transaction.bankAccountId != null) {
      this.transaction.bankAccount = null;
      this.transaction.bankAccountId = null;
    }
  }

  compareAccountFn(a1: BankAccountDto, a2: BankAccountDto) {
    return BankAccountDto.compareAccountById(a1, a2);
  }

  transactionPeriodCompare(e1: CyclicCostPeriod, e2: CyclicCostPeriod) {
    return CyclicCostPeriod.comparePeriod(e1, e2);
  }
}
