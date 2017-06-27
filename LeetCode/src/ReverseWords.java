public class ReverseWords{
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0,j=s.length()-1 , k=0;
        for(int i=s.length()-1;i>=0;i--){
             if(s.charAt(i) == 32)
                j--;
            else
                break;
                
        }
       for(int i=0;i<s.length();i++){
             if(s.charAt(i) == 32)
                k++;
            else
                break;
                
        }
       
       int endin = j+1;
        for(int i=j;i>=k;i--){
            if(s.charAt(i) == 32||i==k){
            	if(i!=j && i!=k && s.charAt(i+1) == 32){
            		endin = i;
            		continue;
            	}
                if(i==k)
                    sb.append(s.substring(i,endin));
                else{
                    sb.append(s.substring(i+1,endin));
                    sb.append(" ");
                }
                    
                endin = i;
                count=0;
            }
            else{
                count++;
            }
        }
        
        return sb.toString();
    }
    
    
    public static void main(String[] args){
    	System.out.println(reverseWords("   a   "));
    }
    
}

