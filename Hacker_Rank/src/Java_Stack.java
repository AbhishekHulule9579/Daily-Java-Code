import java.util.*;
public class Java_Stack{

    public static boolean balance(String s){
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else if(c==')' || c=='}' || c==']'){
                if(stack.empty()){
                    return false;
                }
                char top=stack.pop();
                if((c==')'&& top !='(')||
                        (c=='}' && top !='{') ||
                        (c==']' && top !='[')){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            System.out.println(balance(input));
        }

    }
}



