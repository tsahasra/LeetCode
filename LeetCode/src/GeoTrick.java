import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GeoTrick {

    static void getFactors(int n , int len ,HashMap<Integer,Integer> ht){
        
        int n2 = n*n;
        
        for(int i=1 ; i<= n;i++){
            
            if((n2) % i == 0){
                if((n2) / i != i && !ht.containsKey(i) && (n2) / i <= len ){
                    ht.put(n2 / i , i);
                }
              
            }
        }
            
    }
    
    static int geometricTrick(String s){
        // Complete this function
        ArrayList<Integer> blist = new ArrayList<Integer>();
       
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) == 'b')
                blist.add(i);
            
        if(blist.size() == 0 || blist.size() >= s.length() - 1)
            return 0;
         
        HashMap<Integer,Integer> ht = new HashMap<Integer,Integer>();
        
        int count = 0;
        
         for(Integer j : blist){
            getFactors(j+1,s.length(),ht);
            if(!ht.isEmpty()){
                Set<Integer> set = ht.keySet();
                for(Integer m : set){
                    char c1 = s.charAt(m-1);
                    char c2 = s.charAt(ht.get(m) - 1);
                    if((c1 == 'a' && c2 == 'c') || (c1 == 'c' && c2 == 'a'))
                        count++;
                }
            }
            ht.clear();
        }   
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = geometricTrick(s);
        System.out.println(result);
    }
}