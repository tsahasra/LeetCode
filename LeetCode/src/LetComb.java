import java.util.ArrayList;
import java.util.List;


public class LetComb {
    public static List<String> letterCombinations(String digits) {
        
    	if(digits.length() == 0)
            return new ArrayList<String>();
            
        List<String> li = new ArrayList<String>();
        String[] s = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> temp;
        int dlen = digits.length(),in =0 , slen = 0 ;
       
        
        for(int i=0;i<dlen;i++){
            if(i == 0){
                in = 0;
                slen = s[digits.charAt(0)-'0'].length();
                while(in < slen){
                    li.add(Character.toString(s[digits.charAt(0)-'0'].charAt(in)));
                    in++;
                }
            }
            else{
            in =0;
            temp = new ArrayList<String>();
            slen = s[digits.charAt(i)-'0'].length();
            while(!li.isEmpty()){
                String st = li.remove(0);
                while(in < slen){
                    temp.add(st + s[digits.charAt(i)-'0'].charAt(in));
                    in++;
                }
                in = 0;
            }
            li = temp;
            }
        }
            
            return li;
    }

 public static void main(String[] args){
     System.out.println(letterCombinations("1"));
}   
}