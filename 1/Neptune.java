public class Neptune extends Currency{

  public Neptune(double deposit){
    currencyName = "NeptuneNuggets";
    totalFunds = deposit;
    planetName = "Neptune";
  }

  public double toEarthDollars(double amount){
    double EarthAmount = (1/EarthtoNeptune)*(amount);
    return EarthAmount;
  }

  public double fromEarthDollars(double EarthDollars){
    double result = (EarthDollars)*(EarthtoNeptune);
    return result;
  }

//   public void exchange(Exchangeable other, double amount){
//       if(amount < 0){
//         System.out.println("Converting from EarthDollars to NeptuneNuggets..........");
//         double newAmount  = fromEarthDollars(-amount);
//         totalFunds += newAmount;
//         System.out.println("$" + Math.round((-amount)*100.00)/100.00 + " EarthDollars" + " = $" + Math.round(newAmount*100.00)/100.00 + " NeptuneNuggets.");
//         System.out.println("Funds added to Neptune Account");
//         System.out.println("Neptune now has $" + Math.round(totalFunds*100.00)/100.00 + " " + currencyName);
//         System.out.println("End of transfer---------------------------------------" + '\n');
//       }
//       else if (amount > 0){
//       if(amount > totalFunds){
//         System.out.println("Initiating transfer---------------------------------------");
//         System.out.println("Insufficient funds in Neptune Account");
//         System.out.println("Amount requested : $" + amount + " NeptuneNuggets. Available funds: $" + Math.round(totalFunds*100.00)/100.00 + " NeptuneNuggets.");
//         System.out.println("End of transfer........" + '\n');
//         return;
//       }
//       else {
//         System.out.println("Initiating transfer---------------------------------------");
//         System.out.println("Converting from " + currencyName + " to EarthDollars..........");
//         double EarthAmount = toEarthDollars(amount);
//         System.out.println("$" + amount + " " + currencyName + " = $" + Math.round(EarthAmount*100.00)/100.00 + " EarthDollars.");
//         totalFunds -= amount;
//         System.out.println("Funds removed from Neptune Account");
//         System.out.println("Neptune now has $" + Math.round(totalFunds*100.00)/100.00 + " " + currencyName);
//         other.exchange(other,-EarthAmount);
//   }
// }
//   else{
//     System.out.println("----------------------------------------------------------------------");
//     System.out.println("Transfer amount must be greater than $0 " + currencyName);
//     System.out.println("----------------------------------------------------------------------" + "\n");
//   }
// }

public void exchange(Exchangeable other, double amount){
  Currency change = (Currency) other;
  if(amount <= 0){
    System.out.println("Converting from " + this.currencyName + " to " + change.currencyName + " and initiating tranfer.....");
    System.out.println("Transfer amount must be greater than $0 " + this.currencyName + "\n");
    return;
  }
   if(this.currencyName.equals(change.currencyName)){
    System.out.println("Converting from " + this.currencyName + " to " + change.currencyName + " and initiating tranfer.....");
    System.out.println("Exchanges within the same account is not allowed!!" + "\n");
    return;
  }
  else if(amount > totalFunds){
    System.out.println("Uh oh - " + this.planetName + " only have an available balance of $" + Math.round(totalFunds*100.00)/100.00 + ", which is less than $" + Math.round(amount*100.00)/100.00 + "\n");
    return;
  }
  else{
    double takeout = this.toEarthDollars(amount);
    double input = change.fromEarthDollars(takeout);
    this.totalFunds -= amount;
    change.totalFunds += input;
    System.out.println("Converting from " + this.currencyName + " to " + change.currencyName + " and initiating tranfer.....");
    System.out.println("$" + Math.round(amount*100.00)/100.00 + " " + this.currencyName + " = $" + Math.round(takeout*100.00)/100.00 + " EarthDollars = $" + Math.round(input*100.00)/100.00 + " " + change.currencyName);
    System.out.println(this.planetName + " has a total of $" + Math.round(this.totalFunds*100.00)/100.00 + " " + this.currencyName);
    System.out.println(change.planetName + " has a total of $" + Math.round(change.totalFunds*100.00)/100.00 + " " + change.currencyName + "\n");
  }

}

}
