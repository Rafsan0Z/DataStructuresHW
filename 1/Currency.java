public abstract class Currency implements Exchangeable{

  String currencyName;
  String planetName; 
  double totalFunds;

  public abstract double toEarthDollars(double amount);
  public abstract double fromEarthDollars(double EarthDollars);

}
