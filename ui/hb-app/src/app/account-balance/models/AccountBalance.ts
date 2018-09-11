import {BankAccount} from "../../component-bank-account/models/bank-account";

export class AccountBalance {

  constructor(
    public id: string,
    public value: number,
    public updateDate: Date,
    public bankAccount: BankAccount){}
}
