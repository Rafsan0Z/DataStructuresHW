import java.io.*;

public class Tester{

  public static void main(String[] args) throws IOException{

    double[] deposits = new double[3];
    String[] Accounts = {"Mars","Neptune","Saturn"};

  InputStreamReader input = new InputStreamReader(System.in);
  BufferedReader br = new BufferedReader(input);
  int i = 0;
  boolean collected = false;
  while(!collected){
    try{
      double pay = Double.parseDouble(br.readLine());
      if(pay >= 0.0){
        deposits[i] = pay;
        System.out.println("Payment Successfully collected for " + Accounts[i]);
        i++;
        if(i == 3){collected = true;}
      }
      else{System.out.println("Deposit amount cannot be negative");}
    }
    catch(NumberFormatException e){System.out.println("Input is not a double");}
  }

  Currency mars = new Mars(deposits[0]);
  Currency neptune = new Neptune(deposits[1]);
  Currency saturn = new Saturn(deposits[2]);

  System.out.println("<-- Exchanges -->");
  mars.exchange(saturn, 25.0);
//  System.out.println("done");
  neptune.exchange(saturn, 10.0);
//  System.out.println("done");
  saturn.exchange(mars, 122.0);
//  System.out.println("done");
  saturn.exchange(mars, 121.0);
//  System.out.println("done");


  System.out.println("Below are the total funds remaining for each account");
  System.out.println("Mars has $" + Math.round(mars.totalFunds*100.00)/100.00 + " MarsMoney");
  System.out.println("Saturn has $" + Math.round(saturn.totalFunds*100.00)/100.00 + " SaturnSilver");
  System.out.println("Neptune has $" + Math.round(neptune.totalFunds*100.00)/100.00 + " NeptuneNuggets");



}
}
