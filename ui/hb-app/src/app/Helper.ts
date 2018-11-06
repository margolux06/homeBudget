export class Helper{

  public static toArray(enumme) {
    return Object.keys(enumme)
      .map(key => enumme[key]);
  }

  public static fromJsonToObject<T>(json: any, type: { new(): T; }): T {
    const object = new type();
    return jQuery.extend(object, json as T);
  }

  public static fromJsonsToObject<T>(jsons: any[], type: { new(): T; }): T[] {
    return jsons.map(value => this.fromJsonToObject(value, type));
  }
}
