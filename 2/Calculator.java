public class Calculator{

  private Converter question;
  private LinkedStack<String> storage;

  public Calculator(Converter given){
    question = given;
    storage = new LinkedStack();
  }

  public double evaluate(){
    String taken = question.output;
    double result = 0;
    for(int i = 0; i < taken.length(); i++){
      char test = taken.charAt(i);
      if(Character.isDigit(test)) {
        String number = test + "";
        for(int j = i+1; j < taken.length(); ++j){
          if(Character.isDigit(taken.charAt(j))){
            number += taken.charAt(j);
            i=j;
          }
          else{break;}
        }
        storage.push(number);
      }
      if(isOp(test+"")){
        double one = Double.parseDouble(storage.pop());
        double two = Double.parseDouble(storage.pop());
        result = apply(test+"",two,one);
        storage.push(""+result);
      }
    }
    return Math.round((result*100.00))/100.00;
  }
  private double apply(String c, double a, double b){
    if(c.equals("+")){return a + b;}
    else if(c.equals("-")){return a - b;}
    else if(c.equals("*")){return a*b;}
    else if(c.equals("/")){return a/b;}
    else if(c.equals("^")){return Math.pow(a,b);}
    return -1;
    }

    private static boolean isOp(String c){
      if(c.equals("*") || c.equals("/") || c.equals("+") || c.equals("^") || c.equals("-")) return true;
      return false;
    }
}
