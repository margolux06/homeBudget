import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {CyclicTransactionService} from "../transactions/services/cyclic-transaction.service";
import {CyclicTransactionDto} from "../transactions/models/CyclicTransactionDto";
import {ActivatedRoute} from "@angular/router";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {Subject, Subscription} from "rxjs";
import {ErrorStateMatcher} from "@angular/material";
import {FormControl, FormGroupDirective, NgForm} from "@angular/forms";
import {CyclicCostPeriod} from "../transactions/models/CyclicCostPeriod";

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
  periods: CyclicCostPeriod[] = [CyclicCostPeriod.PER_WEEK, CyclicCostPeriod.PER_MONTH, CyclicCostPeriod.PER_THREE_MONTHS,
    CyclicCostPeriod.PER_YEAR];
  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  transaction: CyclicTransactionDto = new CyclicTransactionDto();
  matcher: MyErrorStateMatcher;

  constructor(private cyclicTransactionService: CyclicTransactionService,
              private bankAccountService: BankAccountService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit() {
    this.fetchAccounts();

  }

  private loadCyclicTransaction() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = this.route.snapshot.paramMap.get("id");

      this.transactionSubscription = this.cyclicTransactionService.findAccountById(id)
        .subscribe(cyclicTransaction => {
          this.transaction = cyclicTransaction.get();
          console.log(this.transaction);
        }, error1 => {
          //  todo:
        })
    }
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
    console.log(this.transaction)
    this.cyclicTransactionService.save(this.transaction).subscribe(
      value => {
        this.location.back();
      },
      error1 => {
      })
  }

  compareAccountFn(a1: BankAccountDto, a2: BankAccountDto) {
    return BankAccountDto.compareAccountById(a1, a2);
  }
}
