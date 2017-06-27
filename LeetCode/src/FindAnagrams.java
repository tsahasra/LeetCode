import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    
   public static boolean compareStrings(String s , HashMap<Integer,Integer> hm){
       
       HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
       
       for(int i=0;i<s.length();i++){
           if(!hs.containsKey((int)s.charAt(i)))
                hs.put((int)s.charAt(i),1);
            else{
                int temp = hs.get((int)s.charAt(i));
                hs.remove((int)s.charAt(i));
                hs.put((int)s.charAt(i),temp+1);
            }
                
           if(!hm.containsKey((int)s.charAt(i)) &&  hs.get((int)s.charAt(i)) > hm.get((int)s.charAt(i)))
                return false;
       }
       
       return true;
   }
    
    public static List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> li = new ArrayList<Integer>();
        
        if(s == null || s.length() == 0 || p.length() > s.length())
            return li;
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        for(int i=0;i<p.length();i++){
           if(!hm.containsKey((int)p.charAt(i)))
                hm.put((int)p.charAt(i),1);
            else{
                int temp = hm.get((int)p.charAt(i));
                hm.remove((int)p.charAt(i));
                hm.put((int)p.charAt(i),temp+1);
            }
        }
        
        long hvp = 0 , hvs = 0;
        
        for(int i=0;i<p.length();i++){
            hvp += p.charAt(i) * Math.pow(3.0,(double)(p.charAt(i) - 97));
        }
        
        int j = 0;
        
        for(j=0;j<p.length();j++){
            hvs += s.charAt(j) * Math.pow(3.0,(double)(s.charAt(j) - 97));
        }
       
       if(hvs == hvp){
           if(compareStrings(s.substring(j-p.length(),j),hm)){
               li.add(j-p.length());
           }
       }
       
       
     
        for(int i=j;i<s.length();i++){
        	long pc = (long) (s.charAt(i-p.length()) * Math.pow(3.0,(double)(s.charAt(i-p.length()) - 97)));
           hvs -= pc;
           //System.out.println(s.charAt(i));
           long nc = (long) (s.charAt(i) * Math.pow(3.0,(double)(s.charAt(i) - 97)));
           hvs += nc;
           
           if(hvs == hvp){
           if(compareStrings(s.substring(i-p.length()+1,i+1),hm)){
               li.add(i-p.length()+1);
           }
           
       }
        }
        
        
        return li;
        
    }
    
    
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader("F:\\input.txt"));
    	String s = br.readLine();
    	br.close();
    	//System.out.println(s.length());
    	
    	BufferedReader br1 = new BufferedReader(new FileReader("F:\\input1.txt"));
    	String p = br1.readLine();
    	br1.close();
    	//System.out.println(p.length());
    	
    	List<Integer> li = findAnagrams(s,p);
    	for(Integer i : li){
    		System.out.println(i);
    	}
    }
    
}