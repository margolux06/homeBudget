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

  public static compareAccountById(a1: BankAccountDto, a2: BankAccountDto){
    if (a1 == null) {
      return a2;
    }
    if (a2 == null) {
      return a1;
    }
    return a1 == a2;
  }
}

export enum BankAccountType {
  EXPENSES = "EXPENSES", SAVINGS = "SAVINGS"
}
