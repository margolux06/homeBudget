import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";

export class AccountBalance {

  constructor(
    public id: string,
    public value: number,
    public updateDate: Date,
    public bankAccount: BankAccountDto){}
}
