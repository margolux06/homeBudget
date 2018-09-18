import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionService} from "./services/one-time-transaction.service";
import {CostDirection} from "./models/CostDirection";
import {OneTimeTransactionDto} from "./models/OneTimeTransactionDto";
import {CyclicTransactionService} from "./services/cyclic-transaction.service";
import {CyclicTransactionDto} from "./models/CyclicTransactionDto";

@Component({
  selector: 'app-settlements',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class Transactions implements OnInit {
  oneTimeTransactionDtos: OneTimeTransactionDto[];
  cyclicTransactionDtos: CyclicTransactionDto[];

  constructor(private oneTimeTransactionService: OneTimeTransactionService,
              private cyclicTransactionService: CyclicTransactionService) {
  }

  ngOnInit() {
    this.loadOneTimeTransactions();
    this.loadCyclicTransactions();
  }

  private loadOneTimeTransactions() {
    this.oneTimeTransactionService.findAllOneTimeTransactions().subscribe(oneTimeTransactions => {
      this.oneTimeTransactionDtos = oneTimeTransactions;
    })
  }

  private loadCyclicTransactions() {
    this.cyclicTransactionService.findAllCyclicTransactions().subscribe(cyclicTransactions =>{
      this.cyclicTransactionDtos = cyclicTransactions;
    })
  }

  isIncoming(cost: OneTimeTransactionDto) {
    return cost.costDirection == CostDirection.INCOMING;
  }
}
