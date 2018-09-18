export class EnumHelper{
  private static stringIsNumber = value => isNaN(Number(value)) === false;

  public static toArray(enumme) {
    return Object.keys(enumme)
      .filter(this.stringIsNumber)
      .map(key => enumme[key]);
  }
}
