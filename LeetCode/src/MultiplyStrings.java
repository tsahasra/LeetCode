public class MultiplyStrings {
    
    public static String multiply(String num1, String num2) {
    	
    	if(num1.equals("0") || num2.equals("0"))
    		return "0";
        
        String s, l;
        int [] mul = new int[num1.length() + num2.length()] ;
        int sindex , lindex;
        
        if(num1.length() >= num2.length())
        {
            l = num1;
            s = num2;
        }
        else
        {
            s = num1;
            l = num2;
        }
        
        sindex = s.length() - 1;
        lindex = l.length() - 1;
        int rindex = mul.length - 1;
        int temp = 0 , unit , tens;
        int i = rindex;
        
        while(sindex >= 0)
        {
           temp =  (s.charAt(sindex) - '0') * (l.charAt(lindex) - '0');
           
           unit = temp % 10;
           tens = temp / 10;
           
           if(mul[rindex] + unit >= 10)
           {
        	   int tempv = mul[rindex] + unit;
        	   mul[rindex] = tempv % 10;
           		mul[rindex - 1] += tempv / 10;
           }
           else
           {
        	   mul[rindex] += unit;
           }
           
           if(mul[rindex - 1] + tens >= 10)
           {
           		int tempv = mul[rindex - 1] + tens;
        	   mul[rindex - 1] = tempv % 10;
           		mul[rindex - 2] += (tempv) / 10;
           }
           else
           {
        	   mul[rindex - 1] += tens;
           }
           
           
           if(lindex == 0)
           {
        	   rindex = --i;
        	   lindex = l.length() - 1;
        	   sindex--;
           }
           else
           {           
        	   rindex--;
        	   lindex--;
           }
        }
        
        boolean flag = false;
            
        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j < mul.length ; j++)    
        {
        	if(mul[j] > 0)
        		flag = true;
        	
        	if(flag == true)
        		sb.append(mul[j]);
         }
        
        return sb.toString();
        
    }
    
    public static void main(String args[])
    {
    	System.out.println(multiply("5646464646464","95"));
    }
}