import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AccountBalance} from "../models/AccountBalance";
import {AccountBalanceCreateDTO} from "../models/AccountBalanceCreateDTO";

@Injectable()
export class AccountBalanceService {
  public static basicAccountBalanceUrl = "http://localhost:8080/accountBalance";

  constructor(private http: HttpClient) { }

  public listAccountBalances(){
    return this.http.get<AccountBalance[]>(AccountBalanceService.basicAccountBalanceUrl);
  }

  createOrUpdateBalances(changedElements: AccountBalanceCreateDTO[]) {
    return this.http.post(AccountBalanceService.basicAccountBalanceUrl, changedElements);
  }
}
