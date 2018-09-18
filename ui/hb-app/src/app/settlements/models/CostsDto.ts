import {BankAccount} from "../../component-bank-account/models/bank-account";

export class CostsDto {

  constructor(
    public id: string,
    public name: string,
    public value: number,
    public cyclic: boolean,
    public costDirection: CostDirection,
    public payDate: number,
    public bankAccount: BankAccount

){}
}

export enum CostDirection{
  INCOMING = "INCOMING",
  OUTGOING = "OUTGOING"
}
