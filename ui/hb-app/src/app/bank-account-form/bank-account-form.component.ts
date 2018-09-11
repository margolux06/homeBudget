import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {BankAccount, BankAccountTypes} from "../component-bank-account/models/bank-account";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";

@Component({
  selector: 'app-bank-account-form',
  templateUrl: './bank-account-form.component.html',
  styleUrls: ['./bank-account-form.component.css']
})
export class BankAccountFormComponent implements OnInit {
  stringIsNumber = value => isNaN(Number(value)) === false;
  accountModel: BankAccount;
  accountTypeKeys = [];


  constructor(
    private accountService: BankAccountService,
    private route: ActivatedRoute,
    private location: Location) {
    this.accountTypeKeys = this.toArray(BankAccountTypes);
  }

  toArray(enumme) {
    return Object.keys(enumme)
      .filter(this.stringIsNumber)
      .map(key => enumme[key]);
  }

  ngOnInit() {
    this.accountModel = new BankAccount(null, "", "", null);
    this.getAccountIdParam();

  }

  onSubmit() {
    this.accountService.createAccount(this.accountModel).subscribe(value => {
      window.history.back();
    })
  }

  private getAccountIdParam() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = +this.route.snapshot.paramMap.get("id");
      console.log(id);
      this.accountService.findAccountById(id).subscribe(bankAccountFormModel => {
        this.accountModel = bankAccountFormModel;
        console.log(JSON.stringify(this.accountModel));
      }, error1 => {
      });
    }
  }
}
