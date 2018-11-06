import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";
import {CostDirection} from "./CostDirection";
import {CyclicCostPeriod} from "./CyclicCostPeriod";

export class CyclicTransactionDto {
  private _bankAccount: BankAccountDto;

  constructor();
  constructor(
    public id?: string,
    public name?: string,
    public value?: number,
    public costDirection?: CostDirection,
    public firstPayDate?: Date,
    public lastPayDate?: Date,
    public period?: CyclicCostPeriod,
    public bankAccountId?: number
  ) {
  }


  get bankAccount(): BankAccountDto {
    return this._bankAccount;
  }

  set bankAccount(value: BankAccountDto) {
    this._bankAccount = value;
  }

  get(){
    this.firstPayDate = new Date(this.firstPayDate);
    this.lastPayDate = new Date(this.lastPayDate);
    return this;
  }
}
