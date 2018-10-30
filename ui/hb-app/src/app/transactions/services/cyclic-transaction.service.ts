import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CyclicTransactionDto} from "../models/CyclicTransactionDto";
import {Helper} from "../../Helper";
import 'rxjs/add/operator/map'

@Injectable()
export class CyclicTransactionService {
  public static basicCyclicTransactionUrl = "http://localhost:8081/cyclicTransaction";

  constructor(private http: HttpClient) {
  }

  findAllCyclicTransactions() {
    return this.http.get<CyclicTransactionDto[]>(CyclicTransactionService.basicCyclicTransactionUrl);
  }

  findAccountById(cyclicId: string) {
    return this.http.get<CyclicTransactionDto>(CyclicTransactionService.basicCyclicTransactionUrl + "/" + cyclicId)
      .map(value => Helper.fromJsonToObject(value, CyclicTransactionDto));
  }
}
