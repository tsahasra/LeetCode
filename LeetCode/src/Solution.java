import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try
    	{
        	Hashtable<Integer,Integer> ht1  = new Hashtable<Integer,Integer>();
        	//Hashtable<String,Integer>  ht2  = new Hashtable<String,Integer>();
        	StringTokenizer str ;
        	String temp = "" , line = "" , engw , kalw ;
        	Scanner stdin = new Scanner(System.in);
        	int tstc = 0 , nos = 0 , stlen[] , count[] , k=0; 
           tstc =Integer.parseInt(stdin.nextLine());
           if(tstc == 0){
        	   System.out.println(0);
           	return ;
           }
           count = new int[tstc];
            int  j = 1 , weight = 0;
            while(j <= tstc) 
            {
         	    
            	nos = Integer.parseInt(stdin.nextLine());
         	    
            	stlen = new int[nos];
            	str = new StringTokenizer(stdin.nextLine()," ");
            	//stlen[0] = Integer.parseInt(str.nextToken());
            	for(int i =0; i<nos;i++)
            	{
            		stlen[i] = Integer.parseInt(str.nextToken());
            		if(ht1.containsKey(stlen[i]))
            			ht1.replace(stlen[i], ht1.get(stlen[i]), ht1.get(stlen[i])+ 1);
            		else            		
            			ht1.put(stlen[i],1);
            		
            		
            		
            	}
            	
            	
            	Set<Integer> keys = ht1.keySet();
            	 
                //Obtaining iterator over set entries
                Iterator<Integer> itr = keys.iterator();
                
                
                while(itr.hasNext())
                {
                	int temp1 = ht1.get(itr.next());
                	 count[k]  += temp1 / 2;
                		
                }
            		
                
         	   k++;
         	   j++;
         	   ht1.clear();
            }
            
            for(k = 0 ; k < tstc; k++)
            	System.out.println(count[k] / 2);
    	
    }catch(Exception e)
    	{
    	System.out.println(e.getMessage());
    	}
}
}