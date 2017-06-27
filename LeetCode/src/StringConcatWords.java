import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringConcatWords {
	
    public static List<Integer> findSubstring(String s, String[] words) {
ArrayList<Integer> li = new ArrayList<Integer>();
        
        int wlen = words[0].length();
        int noofwords = words.length;
        
        Map<String,Integer> hi = new HashMap<String,Integer>(noofwords);
        for(int i=0;i<words.length;i++){
            if(!hi.containsKey(words[i])){
                hi.put(words[i],1);
                
            }else{
                hi.put(words[i],hi.get(words[i])+1);
            }
        }
        
        int sti = 0 , ei = 0;  
        for(int i=0;i<=s.length()-(noofwords*wlen);i++){
            Map<String,Integer> hcopy = new HashMap<String,Integer>(hi);
        
            sti = i;
            ei = i + wlen;
            for(int j=0;j<noofwords;j++){
            	String s1 = s.substring(sti,ei);
                if(hcopy.containsKey(s1)){
                    hcopy.put(s1,hcopy.get(s1)-1);
                    if(hcopy.get(s1) == 0)
                        hcopy.remove(s1);
                    sti+=wlen;
                    ei+=wlen;
                }else{
                	break;
                }
            }
            
            if(hcopy.isEmpty()){
            	li.add(i);
            }
            
            
        }
        return li;
    }
    
    public static void main(String[] args){
    	System.out.println(findSubstring("foobarthebarfoo",new String[]{"foo","bar"}));
    }
}