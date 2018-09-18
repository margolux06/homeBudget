import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OneTimeTransactionDto} from "../models/OneTimeTransactionDto";

@Injectable()
export class OneTimeTransactionService {
  public static basicCostsUrl = "http://localhost:8080/costs";

  constructor(private http: HttpClient) { }

  public findAllCosts(){
    return this.http.get<OneTimeTransactionDto[]>(OneTimeTransactionService.basicCostsUrl);
  }

}
