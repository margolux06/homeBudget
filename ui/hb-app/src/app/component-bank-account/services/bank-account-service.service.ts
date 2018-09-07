import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {BankAccountCreateForm} from "../models/bank-account-create-form";

@Injectable()
export class BankAccountService {
  private static bankAccountUrl = 'http://localhost:8080/account';

  constructor(private http: HttpClient) { }

  getAccounts() {
    return this.http.get(BankAccountService.bankAccountUrl);
  }

  createAccount(bankAccountFormModel: BankAccountCreateForm){
    return this.http.post(BankAccountService.bankAccountUrl, bankAccountFormModel);
  }

  deleteAccount(accountId: number) {
    return this.http.delete(BankAccountService.bankAccountUrl + "/" + accountId);
  }
}
