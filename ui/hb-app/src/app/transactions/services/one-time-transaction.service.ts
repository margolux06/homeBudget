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
    return this.http.get<OneTimeTransactionDto[]>(OneTimeTransactionService.basicCostsUrl)
      .map(value => Helper.fromJsonsToObject(value, OneTimeTransactionDto));
  }

  findAccountById(id: string): Observable<OneTimeTransactionDto> {
    return this.http.get<OneTimeTransactionDto>(OneTimeTransactionService.basicCostsUrl + "/" + id)
      .map(value => Helper.fromJsonToObject(value, OneTimeTransactionDto));
  }

  create(transaction: OneTimeTransactionDto) {
    return this.http.post(OneTimeTransactionService.basicCostsUrl, transaction);
  }

  update(transaction: OneTimeTransactionDto) {
    return this.http.put(OneTimeTransactionService.basicCostsUrl, transaction);
  }

  delete(oneTimeTransactionId: string) {
    return this.http.delete(OneTimeTransactionService.basicCostsUrl + '/' + oneTimeTransactionId);
  }
}
