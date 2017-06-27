import java.util.Stack;

public class IsValidParan {
    public static  boolean isValid(String s) {
        
        Stack<Character> st = new Stack<Character>();
        int len = s.length();
        Character temp = null;
        for(int i=0;i<len;i++){
            Character c = new Character(s.charAt(i));
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
                temp = new Character(c);
            }
            else if(c == ')' || c == ']' || c == '}'){
                if(st.isEmpty())
                    return false;
                Character c1 = st.pop();
                if(!c1.equals(temp))
                    return false;
             }
            
        }
        
        return st.isEmpty();
    }

    public static void main(String[] args){
      System.out.println(isValid("([])"));
}

}
