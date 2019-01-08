import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CyclicCostPeriod} from "../models/CyclicCostPeriod";

@Injectable()
export class CyclicTransactionPeriodService {
  public static basicUrl = "http://localhost:8081/cyclicPeriod";

  constructor(private http: HttpClient) {
  }

  public findAll(){
    return this.http.get<CyclicCostPeriod[]>(CyclicTransactionPeriodService.basicUrl);
  }
}
