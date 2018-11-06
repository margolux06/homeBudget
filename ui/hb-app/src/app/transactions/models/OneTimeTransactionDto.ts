import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";
import {CostDirection} from "./CostDirection";

export class OneTimeTransactionDto {
  private _bankAccount: BankAccountDto;

  constructor();
  constructor(
    public id?: string,
    public name?: string,
    public value?: number,
    public costDirection?: CostDirection,
    public payDate?: Date,
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
    this.payDate = new Date(this.payDate);
    return this;
  }
}
