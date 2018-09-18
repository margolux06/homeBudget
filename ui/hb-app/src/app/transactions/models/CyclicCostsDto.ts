import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";
import {CostDirection} from "./CostDirection";

export class CyclicCostsDto {

  constructor(
    public id: string,
    public name: string,
    public value: number,
    public costDirection: CostDirection,
    public payDate: number,
    public bankAccount: BankAccountDto
  ){

  }
}
