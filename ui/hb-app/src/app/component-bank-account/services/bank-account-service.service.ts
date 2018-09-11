import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {BankAccount} from "../models/bank-account";

@Injectable()
export class BankAccountService {
  private static bankAccountUrl = 'http://localhost:8080/account';

  constructor(private http: HttpClient) { }

  getAccounts() {
    return this.http.get<BankAccount[]>(BankAccountService.bankAccountUrl);
  }

  findAccountById(accountId: number){
    return this.http.get<BankAccount>(BankAccountService.bankAccountUrl + "/" + accountId);
  }

  createAccount(bankAccountFormModel: BankAccount){
    return this.http.post(BankAccountService.bankAccountUrl, bankAccountFormModel);
  }

  deleteAccount(accountId: number) {
    return this.http.delete(BankAccountService.bankAccountUrl + "/" + accountId);
  }
}
