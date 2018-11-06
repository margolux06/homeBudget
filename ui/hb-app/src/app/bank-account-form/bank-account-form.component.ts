import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {ActivatedRoute} from "@angular/router";
import {BankAccountDto, BankAccountType} from "../component-bank-account/models/bank-account-dto";
import {BankAccountService} from "../component-bank-account/services/bank-account-service.service";
import {Helper} from "../Helper";

@Component({
  selector: 'app-bank-account-form',
  templateUrl: './bank-account-form.component.html',
  styleUrls: ['./bank-account-form.component.css']
})
export class BankAccountFormComponent implements OnInit {

  accountModel: BankAccountDto;
  accountTypeKeys = [];


  constructor(
    private accountService: BankAccountService,
    private route: ActivatedRoute,
    private location: Location) {
    this.accountTypeKeys = Helper.toArray(BankAccountType);
  }

  ngOnInit() {
    this.accountModel = new BankAccountDto(null, "", "", null, 0, 0, false);
    this.getAccountIdParam();

  }

  onSubmit() {
    this.accountService.createAccount(this.accountModel).subscribe(value => {
      this.location.back();
    })
  }

  private getAccountIdParam() {
    if (this.route.snapshot.paramMap.has("id")) {
      const id = +this.route.snapshot.paramMap.get("id");
      console.log(id);
      this.accountService.findAccountById(id).subscribe(bankAccountFormModel => {
        this.accountModel = bankAccountFormModel;
      }, error1 => {
      });
    }
  }
}
