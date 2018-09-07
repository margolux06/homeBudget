import {Component, OnInit} from '@angular/core';
import {BankAccountService} from './services/bank-account-service.service';

@Component({
  selector: 'app-component-bank-account',
  templateUrl: './bank-account.component.html',
  styleUrls: ['./bank-account.component.css']
})
export class BankAccountComponent implements OnInit {
  accounts = [];

  constructor(private accountService: BankAccountService) {
  }

  ngOnInit() {
    this.fetchAccounts();
  }

  private fetchAccounts() {
    this.accountService.getAccounts().subscribe((accounts: any[]) => this.accounts = accounts);
  }

  onEditAccount(accountId: number) {
    console.log(accountId);
    //this.accountModel = this.accounts.find(value => value.id == accountId);
  }

  onDeleteAccount(accountId: number) {
    this.accountService.deleteAccount(accountId).subscribe(value => this.fetchAccounts());
  }
}
