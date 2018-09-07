import {Component, OnInit} from '@angular/core';
import {BankAccountService} from './services/bank-account-service.service';
import {Alert} from "selenium-webdriver";

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

  onDeleteAccount(accountId: number) {
    this.accountService.deleteAccount(accountId)
      .subscribe(value => this.fetchAccounts(), error1 => {
        // todo: wystawić coś do błędów
      });
  }
}
