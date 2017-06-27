public class rev2 {
    public static String reverseWords(String s) {
       
       StringBuilder sb = new StringBuilder();
       StringBuilder sb1 = new StringBuilder("");
       for(int i=0;i<s.length();i++){
           
           if(s.charAt(i) != 32){
               String s1 = sb1.toString();
               sb1 = new StringBuilder("");
               sb1.append(s.charAt(i));
               sb1.append(s1);
           }
           else{
               sb.append(sb1.toString());
               sb.append(" ");
               sb1 = new StringBuilder("");    
           }
           
           
       }
       
       sb.append(sb1.toString());
       
       return sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}