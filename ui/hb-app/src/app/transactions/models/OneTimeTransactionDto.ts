import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";
import {CostDirection} from "./CostDirection";

export class OneTimeTransactionDto {

  constructor(
    public id: string,
    public name: string,
    public value: number,
    public costDirection: CostDirection,
    public payDate: Date,
    public bankAccountDto: BankAccountDto
  ) {
  }
}
