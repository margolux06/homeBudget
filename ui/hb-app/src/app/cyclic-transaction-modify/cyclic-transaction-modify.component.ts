import {Component, OnInit} from '@angular/core';
import {CyclicTransactionService} from "../transactions/services/cyclic-transaction.service";
import {CyclicTransactionDto} from "../transactions/models/CyclicTransactionDto";
import {ActivatedRoute} from "@angular/router";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";
import {Subject, Subscription} from "rxjs";

@Component({
  selector: 'cyclic-transaction-modify',
  templateUrl: './cyclic-transaction-modify.component.html',
  styleUrls: ['./cyclic-transaction-modify.component.css']
})
export class CyclicTransactionModifyComponent implements OnInit {
  private transactionSubscription: Subscription;
  private accoutSubscription: Subscription;

  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  bankAccounts: Subject<BankAccountDto[]> = new Subject();
  transaction: CyclicTransactionDto;

  constructor(private cyclicTransactionService: CyclicTransactionService,
              private bankAccountService: BankAccountService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.loadCyclicTransaction();
  }

  private loadCyclicTransaction() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = this.route.snapshot.paramMap.get("id");

      this.transactionSubscription = this.cyclicTransactionService.findAccountById(id)
        .subscribe(cyclicTransaction => {
          this.transaction = cyclicTransaction.get();
          console.log(JSON.stringify(this.transaction));
        }, error1 => {
          //  todo:
        })
    }
  }
  private fetchAccounts() {
    this.accoutSubscription = this.bankAccountService.getAccounts()
      .subscribe(accounts => {
          console.log(accounts);
          this.bankAccounts.next(accounts);
        }
      )
  }

  onSubmit() {

  }

  compareAccounts(c1: CyclicTransactionDto, c2: CyclicTransactionDto) {
    return c1.bankAccountId == c2.bankAccountId;
  }
}
