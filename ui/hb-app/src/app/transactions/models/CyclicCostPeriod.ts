export class CyclicCostPeriod {
  constructor(public id: number,
              public name: string,
              public monthInterval: number) {
  }

  public static comparePeriod(e1: CyclicCostPeriod, e2: CyclicCostPeriod) {
    if (e1 == null) {
      return e2;
    }
    if (e2 == null) {
      return e1;
    }
    return e1.id == e2.id;
  }
}
