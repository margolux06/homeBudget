import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionDto} from "../transactions/models/OneTimeTransactionDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {ActivatedRoute} from "@angular/router";
import {OneTimeTransactionService} from "../transactions/services/one-time-transaction.service";
import {Observable, Subject, Subscription} from "rxjs";
import {FormControl, FormGroupDirective, NgForm} from "@angular/forms";
import {ErrorStateMatcher} from "@angular/material";

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}


@Component({
  selector: 'onetime-transaction-modify',
  templateUrl: './onetime-transaction-modify.component.html',
  styleUrls: ['./onetime-transaction-modify.component.css'],
})
export class OnetimeTransactionModifyComponent implements OnInit {
  private transactionSubscription: Subscription;
  private accoutSubscription: Subscription;

  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  transaction: OneTimeTransactionDto = new OneTimeTransactionDto();

  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  matcher = new MyErrorStateMatcher();
  startDay:Date = new Date();

  constructor(private bankAccountService: BankAccountService,
              private oneTimeTransactionService: OneTimeTransactionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.fetchAccounts();
  }

  compareAccounts(a1: number, a2: number) {
    if (a1 == null) {
      return a2;
    }
    if (a2 == null) {
      return a1;
    }
    return a1 == a2;
  }

  onSubmit() {
    console.log(this.transaction);
    let observable: Observable<Object> =
      this.transaction.id == null ?
        this.oneTimeTransactionService.create(this.transaction)
        : this.oneTimeTransactionService.update(this.transaction);

    observable.subscribe(
      value => {
        window.history.back();
      }, error1 => {
        console.log(error1);
      });
  }

  private fetchAccounts() {
    this.accoutSubscription = this.bankAccountService.getAccounts()
      .subscribe(accounts => {
        this.loadOneTimeTransaction();
        this.bankAccounts.next(accounts);
      })
  }

  private loadOneTimeTransaction() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = this.route.snapshot.paramMap.get("id");

      this.transactionSubscription = this.oneTimeTransactionService.findAccountById(id)
        .subscribe(oneTimeTransaction => {
          this.transaction = oneTimeTransaction.get();
          console.log(this.transaction);
        }, error1 => {
          //  todo:
          console.log(error1);
        });
    }
  }

  ngOnDestroy() {
    this.accoutSubscription.unsubscribe();
    this.transactionSubscription.unsubscribe();
  }
}
