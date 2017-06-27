public class LongestPalindromicSubstring {
    
    public static int calculatePalindrome(String s , int startin){
        int i = 1 , len = s.length(), plen = 1;
        while(startin - i >=0 && startin + i < len && (s.charAt(startin - i) == s.charAt(startin + i))){
             plen+= 2;
             i++;
        }    
        
        return plen;
        
    }
    
    
    public static String longestPalindrome(String s) {
        
        int len = s.length();
        
        if(len <= 1)
            return s;
        
        StringBuilder str = new StringBuilder("$");
        boolean evenflag = false;
        
        int i = 0 ; 
        
        String s1 = "";
        
        if(len%2 == 0){
        	evenflag = true;
            for(i=0 ; i<len;i++){
                str.append(s.charAt(i));
                str.append('$');
            }
            s1 = str.toString();
        }
        else
        	s1 = s;
       
        len = s1.length();  
        int j = 1 ,a[] = new int[len] , plen = 0 , cen = 1 , tcen = -1 , fcen = 0, flen = 1;
        a[0] = 1 ;
        
        while(cen<len){
            plen = calculatePalindrome(s1,cen);
            if(flen < plen){
            	flen = plen;
            	fcen = cen;
            }
            a[cen] = plen;
            tcen = cen;
            j=1;
            if(plen > 1){
             while(j <= plen/2){
             if(cen-j - a[cen-j]/2 != cen - a[cen]/2)
                a[cen+j] = a[cen] - a[cen-j];
             else{
                cen += j;
                break;
             }
             
             j++;
             }
             if(cen == tcen)
            	 cen = cen + plen/2 + 1;
            }
            else
             cen = cen + plen/2 + 1;
        }
          
		if(evenflag){
			str = new StringBuilder();
			int k = fcen - flen/2;
			while(k<(fcen+1+flen/2)){
				if(s1.charAt(k) != '$')
					str.append(s1.charAt(k));
				k++;
			}
			return str.toString();
		}
			
          return s1.substring(fcen-flen/2,fcen+1+flen/2);      
    }
    
    public static void main(String[] args){
    	System.out.println(longestPalindrome("xyzbaabmn"));
    }
}