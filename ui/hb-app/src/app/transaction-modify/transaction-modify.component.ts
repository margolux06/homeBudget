import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionDto} from "../transactions/models/OneTimeTransactionDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {ActivatedRoute} from "@angular/router";
import {OneTimeTransactionService} from "../transactions/services/one-time-transaction.service";
import {CyclicTransactionService} from "../transactions/services/cyclic-transaction.service";
import {CyclicTransactionDto} from "../transactions/models/CyclicTransactionDto";

@Component({
  selector: 'app-cost-create',
  templateUrl: './transaction-modify.component.html',
  styleUrls: ['./transaction-modify.component.css']
})
export class TransactionModifyComponent implements OnInit {
  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  bankAccounts: BankAccountDto[];
  oneTimeTrans: OneTimeTransactionDto;
  cyclicTras: CyclicTransactionDto;
  dateFormat = 'dd-mm-yyyy';
  datepickerOpts = {
    autoclose: true,
    todayBtn: 'linked',
    todayHighlight: true,
    assumeNearbyYear: true,
    format: this.dateFormat
  };

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
    this.loadBankAccounts();
  }

  loadBankAccounts() {
    this.bankAccountService.getAccounts()
      .subscribe(accounts => {
        this.bankAccounts = accounts;
        console.log(this.bankAccounts);
      }
    )
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
        console.log(JSON.stringify(this.oneTimeTrans));
      }, error1 => {
        //  todo:
      });
    }
  }
}
