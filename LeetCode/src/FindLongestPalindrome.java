public class FindLongestPalindrome {
    
    public static int[] calculatePalindrome(String s , int low , int high){
        
        int mid = low + (high-low)/2 , len = high+1-low ,di = 0 , ii = 0;
        int[] result = {1,mid,mid};
        
        if(len == 1)
            return result;
        
        if((high+1-low)%2 == 1){
            di = mid-1;
            ii =mid+1;
        }
        else
        {
            result[0] = 0;
        	di = mid;
            ii =mid+1;
        }
        
        while(di >= low && ii <= high && s.charAt(ii) == s.charAt(di)){
                result[0] += 2;
                di--;
                ii++;
            }   
            
        if(result[0] > 1){
            result[1] = di+1;
            result[2] = ii -1;
        }
            
            
        return result;
        
    }
    
    
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(s == null || len <= 1)
            return s;
        
        int[] result = calculatePalindrome(s,0,len-1);
        int [] temp = new int[3];
        for(int i=1;i<len;i++){
            temp  = calculatePalindrome(s,0,i-1);
            result = (result[0] > temp[0]) ? result : temp;
            
            temp  = calculatePalindrome(s,i,len -1);
            result = (result[0] > temp[0]) ? result : temp;
        }
        
        if(result[0] > 0)
          return s.substring(result[1],result[2]+1);
        else
          return "";
        
    }

   public static void main(String[] args){
     System.out.println(longestPalindrome("babad"));
}   

}