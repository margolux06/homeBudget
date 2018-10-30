import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionDto} from "../transactions/models/OneTimeTransactionDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {ActivatedRoute} from "@angular/router";
import {OneTimeTransactionService} from "../transactions/services/one-time-transaction.service";
import {Subject, Subscription} from "rxjs";

@Component({
  selector: 'onetime-transaction-modify',
  templateUrl: './onetime-transaction-modify.component.html',
  styleUrls: ['./onetime-transaction-modify.component.css']
})
export class OnetimeTransactionModifyComponent implements OnInit {
  private transactionSubscription: Subscription;
  private accoutSubscription: Subscription;

  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  transaction: OneTimeTransactionDto = new OneTimeTransactionDto();

  datepickerOpts = {
    autoclose: true,
    todayBtn: 'linked',
    todayHighlight: true,
    assumeNearbyYear: true,
    format: 'dd-mm-yyyy'
  };

  constructor(private bankAccountService: BankAccountService,
              private oneTimeTransactionService: OneTimeTransactionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.fetchAccounts();
  }

  compareAccounts(a1: BankAccountDto, a2: BankAccountDto) {
    if (a1 == null) {
      return a2;
    }
    if (a2 == null) {
      return a1;
    }
    return a1.id == a2.id;
  }

  onSubmit() {
    this.oneTimeTransactionService.save(this.transaction).subscribe(
      value => {
        window.history.back();
      }, error1 => {
        console.log(error1);
      })
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
