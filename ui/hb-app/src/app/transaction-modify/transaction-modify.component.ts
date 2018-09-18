import {Component, OnInit} from '@angular/core';
import {OneTimeTransactionDto} from "../transactions/models/OneTimeTransactionDto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {BankAccountDto} from "../component-bank-account/models/bank-account-dto";
import {CostDirection} from "../transactions/models/CostDirection";

@Component({
  selector: 'app-cost-create',
  templateUrl: './transaction-modify.component.html',
  styleUrls: ['./transaction-modify.component.css']
})
export class TransactionModifyComponent implements OnInit {
  directions: CostDirection[] = [CostDirection.INCOMING, CostDirection.OUTGOING];
  bankAccounts: BankAccountDto[];
  oneTimeTrans: OneTimeTransactionDto;

  constructor(private bankAccountService: BankAccountService) {
    this.oneTimeTrans = new OneTimeTransactionDto(null, "TestName", 7000.66, CostDirection.INCOMING, 0, null);
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
