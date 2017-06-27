public class MagStr {
    public static int magicalString(int n) {
        
    	if(n == 0)
            return 0;
        
        String ms = "122";
        StringBuilder str = new StringBuilder(ms);
        int i=2,count=1,len=3;
        
        while(len < n){
            char c = ms.charAt(i);
            switch(c){
            	
                case '1':
                    if(ms.charAt(len-1) == '1'){
                        str.append('2');
                        len++;
                    }
                    else{
                        str.append('1');
                        len++;
                        if(n - len >= 0)
                           count++;
                    }
                    break;
                    
                case '2':
                	if(ms.charAt(len-1) == '1'){
                        str.append("22");
                		len += 2;
                    }
                    else{
                        str.append("11");
                        len += 2;
                        if(n - len >= 0)
                            count += 2;
                        else
                            count++;
                      }
                      

                    break;
             }
            
             ms = str.toString();
             i++;
                
        }
        
        return count;
    }
    
    
    public static void main(String[] args){
    	
    	System.out.println(magicalString(8999));
    }
}