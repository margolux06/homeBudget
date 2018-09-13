export class BankAccount {

  constructor(
    public id: number,
    public accountNumber: string,
    public bankName: string,
    public accountType: BankAccountTypes,
    public currentBalance: number,
    public balanceUpdate: number,
    public isChanged: boolean = false
  ){}
}

export enum BankAccountTypes {
  EXPENSES, SAVINGS
}
