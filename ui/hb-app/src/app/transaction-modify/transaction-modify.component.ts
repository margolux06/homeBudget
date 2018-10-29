import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionDto} from "../transactions/models/OneTimeTransactionDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {ActivatedRoute} from "@angular/router";
import {OneTimeTransactionService} from "../transactions/services/one-time-transaction.service";
import {CyclicTransactionService} from "../transactions/services/cyclic-transaction.service";
import {CyclicTransactionDto} from "../transactions/models/CyclicTransactionDto";
import {Subject, Subscription} from "rxjs";

@Component({
  selector: 'app-cost-create',
  templateUrl: './transaction-modify.component.html',
  styleUrls: ['./transaction-modify.component.css']
})
export class TransactionModifyComponent implements OnInit {
  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];

  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  oneTimeTrans: OneTimeTransactionDto;
  cyclicTras: CyclicTransactionDto;

  datepickerOpts = {
    autoclose: true,
    todayBtn: 'linked',
    todayHighlight: true,
    assumeNearbyYear: true,
    format: 'dd-mm-yyyy'
  };

  accoutSubscription: Subscription;

  constructor(private bankAccountService: BankAccountService,
              private oneTimeTransactionService: OneTimeTransactionService,
              private cyclicTransactionService: CyclicTransactionService,
              private route: ActivatedRoute) {
    this.oneTimeTrans = new OneTimeTransactionDto(null, "TestName", 7000.66, CostDirection.INCOMING,
      new Date(), null);
  }

  ngOnInit() {
    this.loadCyclicTransaction();
    this.loadOneTimeTransaction();
  }

  private fetchAccounts() {
    this.accoutSubscription = this.bankAccountService.getAccounts()
      .subscribe(accounts => {
          console.log(accounts);
          this.bankAccounts.next(accounts);
        }
      )
  }

  ngOnDestroy() {
    this.accoutSubscription.unsubscribe();
  }

  compareAccounts(a1: BankAccountDto, a2: BankAccountDto){
    return a1.id == a2.id;
  }

  private loadCyclicTransaction() {
    if (this.route.snapshot.paramMap.has("cyclicId")) {
      const id = this.route.snapshot.paramMap.get("cyclicId");
      this.cyclicTransactionService.findAccountById(id).subscribe(cyclicTransaction => {
        this.cyclicTras = cyclicTransaction;
        console.log(JSON.stringify(this.cyclicTras));
      }, error1 => {
        //  todo:
      });
    }
  }

  private loadOneTimeTransaction() {
    if (this.route.snapshot.paramMap.has("oneTimeId")) {
      const id = this.route.snapshot.paramMap.get("oneTimeId");
      this.oneTimeTransactionService.findAccountById(id).subscribe(oneTimeTransaction => {
        this.oneTimeTrans = oneTimeTransaction;
        this.oneTimeTrans.payDate = new Date(this.oneTimeTrans.payDate);
        console.log(this.oneTimeTrans);

        this.fetchAccounts();
      }, error1 => {
        //  todo:
        console.log(error1);
      });
    }
  }
}
