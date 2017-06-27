public class repss {
    public static boolean repeatedSubstringPattern(String s) {
       if(s.length() == 1)
            return false;
            
        String ss = s.substring(0,1);
        StringBuilder sb = new StringBuilder();
        sb.append(ss);
        int i=1, j=0;
        boolean repflag = false;
        
        for(i = 1;i<s.length();i++,j++){
            //sb.append(s.charAt(i));
            

        	if(j == ss.length())
                j=0;
            
            if(s.charAt(i) == ss.charAt(j)){
                repflag = true;
            }
            else{
                repflag = false;
                j = -1;
                sb = new StringBuilder(ss);
                sb.append(s.charAt(ss.length()));
                ss = sb.toString();
                if(s.length() - ss.length() < ss.length())
                    return false;
                i = ss.length();
                i--;
            }
            
        }
        
        if(j < ss.length())
            repflag = false;
        
        return repflag;
    }
    
    
    public static void main(String[] args){
    	System.out.println(repeatedSubstringPattern("a"));
    }
}