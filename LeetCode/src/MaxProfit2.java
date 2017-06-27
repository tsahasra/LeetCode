public class MaxProfit2 {
    public static  int maxProfit(int[] prices) {
        int maxprofit= 0 , msf = 0 , len = prices.length;
        
        for(int i =1; i<len;i++){
            if(prices[i] - prices[i-1] > 0)
                msf += (prices[i] - prices[i-1]);
            else{
                maxprofit += msf;
                msf = 0;
            }
        }
        
         return maxprofit;       
    }

    public static void main(String[] args){
     System.out.println(maxProfit(new int[]{7, 2, 4,1,9}));
}   
  
}