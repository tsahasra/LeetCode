public class PermutationInString {
    
    public static boolean checkPermutation(String s , int[] t){
        
        for(int i=0;i<s.length();i++){
            int index = (int)s.charAt(i) - 97;
            if(t[index] > 0)
                t[index]--;
            else
                return false;
        }
        
        return true;
    }
    
    public static boolean checkInclusion(String s1, String s2) {
        
        if(s2.length() < s1.length())
            return false;
            
       int  hv = 0 , a[] = new int[26];
       
       for(int i =0; i<s1.length();i++)
        {
            hv += (int)s1.charAt(i) - 97;
            int in = (int)s1.charAt(i) -97;
            a[in]++;
        }
      
      int[] temp = a;
      
      int thv = 0 , i =0;
      
      for(i=0 ; i<s1.length();i++){
         thv += (int)s2.charAt(i) - 97; 
      }
         if(thv == hv){
            if(checkPermutation(s2.substring(0,i) , temp))
                return true;
                
            temp = a;
         }
         
               
      for(int j = i ; j<s2.length() ; j++){
          thv -= (int)s2.charAt(j-s1.length()) - 97;
          thv += (int)s2.charAt(j) - 97;
          if(thv == hv){
        	  int in1 = j-s1.length()+1 , in2 = j+1;
        	  
        	  if(checkPermutation(s2.substring(in1 , in2) ,temp ))
                  return true;
                  
              temp = a;
           }
           
      }
       
       
       return false;
    }
    
  public static void main(String[] args){
	  System.out.println(checkInclusion("abc","bbbca"));
  }
  
}