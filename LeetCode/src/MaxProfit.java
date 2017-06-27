public class MaxProfit {
    public static int maxProfit(int[] prices) {
    	if(prices.length <= 1)
            return 0;
            
        int len = prices.length,i=0,j=len-1,min=prices[0],mini=0,maxi=len-1,max=prices[len-1],min1=prices[0],max1=prices[len-1];
        
        for(i=1,j=len-2;i<len && j>=0;i++,j--){
             if(prices[i] < min){
                min = prices[i];
                mini = i;
            }
            if(prices[j] > max){
                max = prices[j];
                maxi = j;
            }
        }
        
        if(maxi == 0 && mini == len -1)
            return 0;
            
        for(i =0,j=len-1;i<maxi || j>mini;i++,j--){
            if(i<maxi && prices[i] < min1 ){
                min1 = prices[i];
            }
            if(j > mini && prices[j] > max1){
                max1 = prices[j];
            }
        }
        
        if(max - min1 > max1 - min)
            return max-min1;
        else
            return max1-min;
          
    }

    public static void main(String[] args){
     System.out.println(maxProfit(new int[]{2,7,1,4}));
}   
}