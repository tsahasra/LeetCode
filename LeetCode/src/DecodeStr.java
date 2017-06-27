import java.util.Stack;

public class DecodeStr {
    public static String decodeString(String s) {
        Stack<String> st = new Stack<String>();
        StringBuilder str = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        
        switch(c){
                case '[':
                        st.push(Character.toString(c));
                        break;
                        
                case ']':
                        
                        String s1= st.pop() , t ="";
                        
                        while(s1.charAt(0) != '['){
                        	str = new StringBuilder();
                            str.append(s1);
                            str.append(t);
                            t = str.toString();
                            s1 = st.pop();
                        }
                        
                        
                        int in1 = Integer.parseInt(st.pop());
                        str = new StringBuilder();
                        
                        for(int j=0;j<in1;j++){
                            str.append(t);
                        }
                        
                        st.push(str.toString());
                        break;
                        
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    int val = 0;
                    if(i>0 && ((int)s.charAt(i-1) >= 48 && (int)s.charAt(i-1) <= 57)){
                        val = Integer.parseInt(st.pop()) * 10 + Integer.parseInt(Character.toString(c));
                        
                    }
                    else
                    {
                        val = Integer.parseInt(Character.toString(c));
                    }
                    st.push(Integer.toString(val));   
                    break;
                    
                default:
                    str = new StringBuilder();
                    if(i>0 && s.charAt(i-1) != '[' && s.charAt(i-1) != ']' && ((int)s.charAt(i-1) < 48 || (int)s.charAt(i-1) > 57)){
                        str.append(st.pop());
                     }
                    str.append(Character.toString(c));
                    st.push(str.toString());
                    break;
            }
            
            
        }
        
        
        String s2 = "";
        while(!st.empty()){
        	str = new StringBuilder();
            str.append(st.pop());
            str.append(s2);
            s2 = str.toString();
        }
        
        return s2;
    }
    
    public static void main(String args[]){
    	System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}