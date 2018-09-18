import {Component, OnInit} from '@angular/core';
import {CostsService} from "./services/costs.service";
import {CostDirection} from "./models/CostDirection";
import {CostsDto} from "./models/CostsDto";

@Component({
  selector: 'app-settlements',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class Transactions implements OnInit {
  costs: CostsDto[];

  constructor(private costsService: CostsService) {
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

  isIncoming(cost: CostsDto) {
    return cost.costDirection == CostDirection.INCOMING;
  }

}
