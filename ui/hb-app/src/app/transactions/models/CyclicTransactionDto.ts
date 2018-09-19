import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";
import {CostDirection} from "./CostDirection";
import {CyclicCostPeriod} from "./CyclicCostPeriod";

export class CyclicTransactionDto {

  constructor(
    public id: string,
    public name: string,
    public value: number,
    public costDirection: CostDirection,
    public firstPayDate: Date,
    public lastPayDate: Date,
    public period: CyclicCostPeriod,
    public bankAccountDto: BankAccountDto
  ){}
}
