import java.util.List;
import java.util.ArrayList;
public class Converter{

  private String input;
  public String output;
  private List<String> token;
  private LinkedStack<String> storage;

  @SuppressWarnings({"unchecked"})
  public Converter(String given){
    storage = new LinkedStack();
    setInput(given);
  }

  public String toPostFix(){
    String result = " ";
    for(String look: token){
      if(look.equals("(") || isOp(look)) {
          if((isOp(look) && storage.top() != null && isOp(storage.top())) && (Pref(look) <= Pref(storage.top()))) result += storage.pop() + " ";
          storage.push(look);
        }
      else if(look.equals(")")){
        String take = storage.pop();
        while(!take.equals("(")){
          result += take + " ";
          take = storage.pop();
        }
      }
      else result += look + " ";
    }
      while(storage.top() != null) result += storage.pop() + " ";
      return result;
    }

  private int Pref(String op){
    if(op.equals("+") || op.equals("-")) return 1;
    if(op.equals("/") || op.equals("*")) return 2;
    if(op.equals("^")) return 3;
    else return -1;
  }

  private char[] toChar(){
    int length = input.length();
    char[] result = new char[length];
    for(int i = 0; i < length; i++){
      result[i] =  input.charAt(i);
    }
    return result;
  }

  private List<String> parse(char[] input) {
    List<String> parsed = new ArrayList<String>();
    for (int i = 0; i < input.length; ++i) {
        char c = input[i];
        if (Character.isDigit(c)) {
            String number = input[i] + "";
            for (int j = i + 1; j < input.length; ++j) {
                if (Character.isDigit(input[j])) {
                    number += input[j];
                    i = j;
                } else {
                    break;
                }
            }
            parsed.add(number);
        } else if (c == '*' || c == '/' ||
                   c == '+' || c == '^' ||
                   c == '-' || c == '(' || c == ')') {
            parsed.add(c + "");
        }
    }
    return parsed;
}

private static boolean isOp(String c){
  if(c.equals("*") || c.equals("/") || c.equals("+") || c.equals("^") || c.equals("-")) return true;
  return false;
}

  public void setInput(String newInput){
    input = newInput;
    token = parse(toChar());
    output = toPostFix();
  }

}
