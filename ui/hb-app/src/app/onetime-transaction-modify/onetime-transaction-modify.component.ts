import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
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
  private subscriptions = new Subscription();

  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  transaction: OneTimeTransactionDto = new OneTimeTransactionDto();

  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  matcher = new MyErrorStateMatcher();
  startDay = new Date();

  constructor(private bankAccountService: BankAccountService,
              private oneTimeTransactionService: OneTimeTransactionService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit() {
    this.fetchAccounts();
  }

  compareAccountFn(a1: BankAccountDto, a2: BankAccountDto) {
    if(a1 == null || a2 == null)
      return null;
    return BankAccountDto.compareAccountById(a1, a2);
  }

  onSubmit() {
    console.log(this.transaction);
    let observable: Observable<any> =
      this.transaction.id == null ?
        this.oneTimeTransactionService.create(this.transaction)
        : this.oneTimeTransactionService.update(this.transaction);

    observable.subscribe(
      value => {
        this.location.back();
      }, error1 => {
        console.log("onSubmit error : " + error1);
      });
  }

  private fetchAccounts() {
    this.subscriptions.add(this.bankAccountService.getAccounts()
      .subscribe(accounts => {
        this.bankAccounts.next(accounts);
        this.loadOneTimeTransaction();
      }, error1 => {
        console.log("fetchAccounts error" + error1);
      }));
  }

  private loadOneTimeTransaction() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = this.route.snapshot.paramMap.get("id");

      this.subscriptions.add(this.oneTimeTransactionService.findAccountById(id)
        .subscribe(oneTimeTransaction => {
          this.transaction = oneTimeTransaction.get();
        }, error1 => {
          //  todo:
          console.log(error1);
        }));
    }
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }

  changedBindToBankAccount() {
    if(this.transaction.bankAccountId != null){
      this.transaction.bankAccount = null;
      this.transaction.bankAccountId = null;
    }
  }
}
