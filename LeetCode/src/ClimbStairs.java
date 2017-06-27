public class ClimbStairs {
    public static int fact(int n){
          if (n == 0)    
            return 1;    
        else    
            return(n * fact(n-1));
    }
    
    public static int climbStairs(int n) {
        if(n == 0)
            return 1;
        int n1=n%2,n2=n/2;
        int count=0;
       
        while(n2>=0){
            int sum= fact(n1+n2) ;
            int r1 = fact(n1);
            int r2 = fact(n2);
            int temp = sum / (n1 * n2);
            count += temp;
            n2--;
            n1+=2;
        }
        
        return count;   
    }

   public static void main(String[] args){
     System.out.println(climbStairs(35));
   }   

}