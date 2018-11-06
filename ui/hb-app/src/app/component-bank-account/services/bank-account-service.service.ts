import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BankAccountDto} from "../models/bank-account-dto";

@Injectable()
export class BankAccountService {
  private static bankAccountUrl = 'http://localhost:8081/account';

  constructor(private http: HttpClient) { }

  getAccounts() {
    return this.http.get<BankAccountDto[]>(BankAccountService.bankAccountUrl);
  }

  findAccountById(accountId: number){
    return this.http.get<BankAccountDto>(BankAccountService.bankAccountUrl + "/" + accountId);
  }

  createAccount(bankAccountFormModel: BankAccountDto){
    return this.http.post(BankAccountService.bankAccountUrl, bankAccountFormModel);
  }

  deleteAccount(accountId: number) {
    return this.http.delete(BankAccountService.bankAccountUrl + "/" + accountId);
  }
}
