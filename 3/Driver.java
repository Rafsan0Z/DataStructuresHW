import java.util.Scanner;
public class Driver{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter an upper bound: ");
    int bound = Integer.parseInt(input.nextLine());
    if(bound < 2){
      System.out.println("Error! Input must be greater than 2");
      System.exit(1);
    }
    Sieve test = new Sieve();
    test.primesTo(bound);
  }

}
