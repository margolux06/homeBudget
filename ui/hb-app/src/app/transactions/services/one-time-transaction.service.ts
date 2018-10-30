import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OneTimeTransactionDto} from "../models/OneTimeTransactionDto";
import {Helper} from "../../Helper";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map'

@Injectable()
export class OneTimeTransactionService {
  public static basicCostsUrl = "http://localhost:8081/oneTimeTransactions";

  constructor(private http: HttpClient) {
  }

  public findAllOneTimeTransactions(): Observable<OneTimeTransactionDto[]> {
    return this.http.get<OneTimeTransactionDto[]>(OneTimeTransactionService.basicCostsUrl);
  }

  findAccountById(id: string): Observable<OneTimeTransactionDto> {
    return this.http.get<OneTimeTransactionDto>(OneTimeTransactionService.basicCostsUrl + "/" + id)
      .map(value => Helper.fromJsonToObject(value, OneTimeTransactionDto));
  }
}
