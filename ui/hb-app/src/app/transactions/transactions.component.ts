import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionService} from "./services/one-time-transaction.service";
import {CostDirection} from "./models/CostDirection";
import {OneTimeTransactionDto} from "./models/OneTimeTransactionDto";

@Component({
  selector: 'app-settlements',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class Transactions implements OnInit {
  costs: OneTimeTransactionDto[];

  constructor(private costsService: OneTimeTransactionService) {
  }

  ngOnInit() {
    this.loadCosts();
  }

  loadCosts() {
    this.costsService.findAllCosts().subscribe(costsList => {
      this.costs = costsList;
      console.log(this.costs);
    })
  }

  isIncoming(cost: OneTimeTransactionDto) {
    return cost.costDirection == CostDirection.INCOMING;
  }

}
