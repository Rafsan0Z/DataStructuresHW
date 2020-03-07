import java.util.Scanner;
public class PostfixCalculator{

  @SuppressWarnings({"unchecked"})
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String tester = "";
    LinkedStack<String> testset = new LinkedStack();
    while(!tester.toUpperCase().equals("DONE")){
      System.out.println("Type your infix expression. Type Done if you are finished");
      tester = input.nextLine();
      if(!tester.toUpperCase().equals("DONE")) testset.push(tester);   // If you want to test using Scanner
    }
    System.out.println("-----------------------------------------------------------------" + "\n");
    // testset.push("3+4*5/6");
    // testset.push("(300+23)*(43-21)/(84+7)");
    // testset.push("(4+8)*(6-5)/((3-2)*(2+2))");
    while(testset.top() != null){
      String name = testset.pop();
      System.out.println("Infix expression is: " + name);
      Converter question = new Converter(name);
      Calculator answer = new Calculator(question);
      System.out.println("Converted to postfix: " + question.output);
      System.out.println("Answer is: " + answer.evaluate());
    }
  }

}
