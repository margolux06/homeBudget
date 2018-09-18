import {BankAccountDto} from "../../component-bank-account/models/bank-account-dto";

export class CostsDto {

  constructor(
    public id: string,
    public name: string,
    public value: number,
    public cyclic: boolean,
    public costDirection: CostDirection,
    public payDate: number,
    public bankAccount: BankAccountDto

){}
}

export enum CostDirection{
  INCOMING = "INCOMING",
  OUTGOING = "OUTGOING"
}
