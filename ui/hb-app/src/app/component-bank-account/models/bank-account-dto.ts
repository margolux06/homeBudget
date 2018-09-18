export class BankAccountDto {

  constructor(
    public id: number,
    public accountNumber: string,
    public bankName: string,
    public accountType: BankAccountType,
    public currentBalance: number,
    public balanceUpdate: number,
    public isChanged: boolean = false
  ){}
}

export enum BankAccountType {
  EXPENSES = "EXPENSES", SAVINGS = "SAVINGS"
}
