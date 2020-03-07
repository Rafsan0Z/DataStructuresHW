public class Driver{

  public static void main(String[] args){

    Currency mars = new Mars(100.00);
    Currency neptune = new Neptune(100.00);
    Currency saturn = new Saturn(100.00);

    System.out.println("<--- Acount Status ---->");
    System.out.println("Mars has $" + Math.round(mars.totalFunds*100.00)/100.00 + " MarsMoney");
    System.out.println("Saturn has $" + Math.round(saturn.totalFunds*100.00)/100.00 + " SaturnSilver");
    System.out.println("Neptune has $" + Math.round(neptune.totalFunds*100.00)/100.00 + " NeptuneNuggets");

    System.out.println("\n");

    System.out.println("<-- Exchanges -->");
    mars.exchange(saturn, 25.0);
    neptune.exchange(saturn, 10.0);
    saturn.exchange(mars, 122.0);
    saturn.exchange(mars, 121.0);

    mars.exchange(neptune,0.0);
    neptune.exchange(mars,0.0);
    saturn.exchange(mars,0.0);

    mars.exchange(mars,100.0);
    saturn.exchange(saturn,100.0);
    neptune.exchange(neptune,100.0);


    System.out.println("<--- Acount Status ---->");
    System.out.println("Mars has $" + Math.round(mars.totalFunds*100.00)/100.00 + " MarsMoney");
    System.out.println("Saturn has $" + Math.round(saturn.totalFunds*100.00)/100.00 + " SaturnSilver");
    System.out.println("Neptune has $" + Math.round(neptune.totalFunds*100.00)/100.00 + " NeptuneNuggets");

  }

}
