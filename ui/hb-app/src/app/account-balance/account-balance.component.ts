import {Component, OnInit} from '@angular/core';
import {AccountBalance} from "./models/AccountBalance";
import {AccountBalanceService} from "./services/account-balance.service";
import {AccountBalanceCreateDTO} from "./models/AccountBalanceCreateDTO";
import {BankAccount} from "../component-bank-account/models/bank-account";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";

@Component({
  selector: 'app-account-balance',
  templateUrl: './account-balance.component.html',
  styleUrls: ['./account-balance.component.css']
})
export class AccountBalanceComponent implements OnInit {
  bankAccounts: BankAccount[] = [];
  hasChanges: boolean = false;
  private changedElements: AccountBalanceCreateDTO[];

  constructor(private accountService: BankAccountService, private balanceService: AccountBalanceService) {
  }

  ngOnInit() {
    this.loadBankAccounts();
  }

  loadBankAccounts() {
    this.accountService.getAccounts().subscribe(bankAccountList => {
      this.bankAccounts = bankAccountList;
    }, error1 => {
      // todo: dodać obsługę błędów
    });
  }

  onSaveClick() {
    this.changedElements = this.bankAccounts
      .filter(value => value.isChanged)
      .map(value => new AccountBalanceCreateDTO(value.id, value.currentBalance));
    this.balanceService.createOrUpdateBalances(this.changedElements).subscribe(value => {
      this.loadBankAccounts();
    });
  }
}
