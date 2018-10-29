import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CyclicTransactionDto} from "../models/CyclicTransactionDto";

@Injectable()
export class CyclicTransactionService {
  public static basicCyclicTransactionUrl = "http://localhost:8081/cyclicTransaction";

  constructor(private http: HttpClient) {
  }

  findAllCyclicTransactions() {
    return this.http.get<CyclicTransactionDto[]>(CyclicTransactionService.basicCyclicTransactionUrl);
  }

  findAccountById(cyclicId: string) {
    return this.http.get<CyclicTransactionDto>(CyclicTransactionService.basicCyclicTransactionUrl + "/" + cyclicId);
  }
}
