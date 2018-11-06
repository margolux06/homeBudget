import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionService} from "./services/one-time-transaction.service";
import {CostDirection} from "./models/CostDirection";
import {OneTimeTransactionDto} from "./models/OneTimeTransactionDto";
import {CyclicTransactionService} from "./services/cyclic-transaction.service";
import {CyclicTransactionDto} from "./models/CyclicTransactionDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class Transactions implements OnInit {
  oneTimeTransactionDtos: OneTimeTransactionDto[];
  cyclicTransactionDtos: CyclicTransactionDto[];
  private bankAccounts: BankAccountDto[];

  constructor(private oneTimeTransactionService: OneTimeTransactionService,
              private cyclicTransactionService: CyclicTransactionService,
              private bankAccountService: BankAccountService) {
  }

  ngOnInit() {
    this.loadBankAccounts();
  }

  private loadBankAccounts() {
    this.bankAccountService.getAccounts().subscribe(value => {
      this.bankAccounts = value;
      this.loadOneTimeTransactions();
      this.loadCyclicTransactions();
    })
  }

  private loadOneTimeTransactions() {
    this.oneTimeTransactionService.findAllOneTimeTransactions().subscribe(oneTimeTransactions => {
      this.oneTimeTransactionDtos = oneTimeTransactions;
      this.oneTimeTransactionDtos.map(this.bankAutocomplete())
    })
  }

  private loadCyclicTransactions() {
    this.cyclicTransactionService.findAllCyclicTransactions().subscribe(cyclicTransactions => {
      this.cyclicTransactionDtos = cyclicTransactions;
      console.log(this.cyclicTransactionDtos);
      this.cyclicTransactionDtos.map(this.bankAutocomplete());
    })
  }

  private bankAutocomplete() {
    return transaction => {
      return transaction.bankAccount =
        this.bankAccounts.find(value1 => {
          return value1.id == transaction.bankAccountId;
        });
    }
  }

  isIncoming(cost: OneTimeTransactionDto) {
    return cost.costDirection == CostDirection.INCOMING;
  }
}
