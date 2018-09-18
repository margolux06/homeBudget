import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CostsDto} from "../models/CostsDto";

@Injectable()
export class CostsService {
  public static basicCostsUrl = "http://localhost:8080/costs";

  constructor(private http: HttpClient) { }

  public findAllCosts(){
    return this.http.get<CostsDto[]>(CostsService.basicCostsUrl);
  }

}
