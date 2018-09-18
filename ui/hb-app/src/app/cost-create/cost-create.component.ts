import {Component, OnInit} from '@angular/core';
import {CostsDto} from "../transactions/models/CostsDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";

@Component({
  selector: 'app-cost-create',
  templateUrl: './cost-create.component.html',
  styleUrls: ['./cost-create.component.css']
})
export class CostCreateComponent implements OnInit {
  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  bankAccounts: BankAccountDto[];
  cost: CostsDto;

  constructor(private bankAccountService: BankAccountService) {
    this.cost = new CostsDto(null, "TestName", 7000.66, CostDirection.INCOMING, 0, null);
  }

  ngOnInit() {
    this.loadBankAccounts();
  }

  loadBankAccounts(){
    this.bankAccountService.getAccounts().subscribe(accounts =>{
      this.bankAccounts = accounts;
      }
    )
  }

}
