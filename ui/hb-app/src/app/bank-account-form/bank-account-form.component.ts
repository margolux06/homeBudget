import { Component, OnInit } from '@angular/core';
import {BankAccountCreateForm, BankAccountTypes} from "../component-bank-account/models/bank-account-create-form";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";

@Component({
  selector: 'app-bank-account-form',
  templateUrl: './bank-account-form.component.html',
  styleUrls: ['./bank-account-form.component.css']
})
export class BankAccountFormComponent implements OnInit {
  stringIsNumber = value => isNaN(Number(value)) === false;
  accountModel: BankAccountCreateForm;
  accountTypeKeys = [];


  constructor(private accountService: BankAccountService) {
    this.accountTypeKeys = this.toArray(BankAccountTypes);
  }

  toArray(enumme) {
    return Object.keys(enumme)
      .filter(this.stringIsNumber)
      .map(key => enumme[key]);
  }

  ngOnInit() {
    this.accountModel = new BankAccountCreateForm("", "", null);
  }

  onSubmit() {
    this.accountService.createAccount(this.accountModel).subscribe(value => {
      window.history.back();
    })
  }
}
