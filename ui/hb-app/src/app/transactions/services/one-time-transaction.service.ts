import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OneTimeTransactionDto} from "../models/OneTimeTransactionDto";

@Injectable()
export class OneTimeTransactionService {
  public static basicCostsUrl = "http://localhost:8080/oneTimeTransactions";

  constructor(private http: HttpClient) { }

  public findAllOneTimeTransactions(){
    return this.http.get<OneTimeTransactionDto[]>(OneTimeTransactionService.basicCostsUrl);
  }

  findAccountById(id: string) {
    return this.http.get<OneTimeTransactionDto>(OneTimeTransactionService.basicCostsUrl + "/" + id);
  }
}
