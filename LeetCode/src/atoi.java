/**
 * 
 */

/**
 * @author Tejas
 *
 */
public class atoi {
	
	public atoi()
	{
		
	}
	
	 String reverseStr(String str) {
	    StringBuilder sb = new StringBuilder();
	       int i=0;
	        
	        for(i=str.length() - 1;i>=0;i--)
	            sb.append(str.charAt(i));
	            
	   return sb.toString();
	    }
    public int myAtoi(String str) {
        
    	if(str.length() == 0)
            return 0;
        str = str.trim();
    	//	System.out.println(str);
          
        int a = 1 , num = 0,i =0 , j=0 ;
               
        if(str.charAt(0) == '-' )
        {
            a = a * (-1);
        	i = 1;
        }
        else if(str.charAt(0) == '+')
        {	
        	i = 1;
        }
       
        for(;i<str.length();i++)
           {
             
        	       
        	if(j == 9 && (int)str.charAt(i) == 57   && num <= (Integer.MIN_VALUE / 10))
        		            return Integer.MIN_VALUE;
        	 		   else if(j == 9 && (int)str.charAt(i) > 55 && (int)str.charAt(i) <=57 && num >= (Integer.MAX_VALUE / 10))
        	 			   return Integer.MAX_VALUE;
        	 		   else if(j == 10 && (int)str.charAt(i) >= 48 && (int)str.charAt(i) <=57 && num < 0)
        	 			   return Integer.MIN_VALUE;
        	 		   else if(j == 10 && (int)str.charAt(i) >= 48 && (int)str.charAt(i) <=57 && num > 0)
        	 			  return Integer.MAX_VALUE;        	 			   
        	           else if((int)str.charAt(i) >= 48 && (int)str.charAt(i) <=57 )
                         {
        	        	      num = num * 10 + a * ((int)str.charAt(i) - 48);
                               j++;
        	        	   
                         }
                        else
                        {
                        	break;
                        }
                         
                                             
               }
        	 	
               
        	
        	
               return num;
               
           }
           
           
           
           
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		atoi a = new atoi();
		System.out.println(a.myAtoi("-2147483649"));
		System.out.println(a.reverseStr("stop"));

	}

}
