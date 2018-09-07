export class BankAccountCreateForm {

  constructor(
    public accountNumber: string,
    public bankName: string,
    public accountType: BankAccountTypes
  ){}
}

export enum BankAccountTypes {
  EXPENSES, SAVINGS
}
