public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int temp1 = nums[0] , temp2 = nums[nums.length-1] , sum2 = nums[nums.length-1], sum1 = nums[0] , index2 = nums.length-1, index1 = 0 , max = nums[0],sum=0;
        for(int i=1,j=nums.length-2;i<nums.length&&j>=0;i++,j--){
            if(sum1 < temp1 + nums[i]){
                index1 = i;
                sum1 = temp1 + nums[i];
            }
            if(sum2 < temp2 + nums[j]){
                index2 = j;
                sum2 = temp2 + nums[j];
            }
            temp1 += nums[i];
            temp2 += nums[j];
            
            if(max < nums[i])
            	max = nums[i];
        }
        
        if(sum1>sum2){
        sum1 = nums[index1];
        temp1 = sum1;
        for(int i=index1-1;i>=0;i--){
            if(sum1 < temp1 + nums[i]){
                index1 = i;
                sum1 = temp1 + nums[i];
            }
            temp1 += nums[i];
        }
        sum = sum1;
        }
        else{
        	sum2 = nums[index2];
            temp2 = sum2;
        	for(int j=index2+1;j<nums.length;j++){
                if(sum2 < temp2 + nums[j]){
                    index2 = j;
                    sum2 = temp2 + nums[j];
                }
                temp2 += nums[j];
            }
        	sum=sum2;
        }
        	
        
        
        return (sum > max)?sum:max;
    }

  public static void main(String[] args){
   System.out.println(maxSubArray(new int[]{0,-3,1,3,-3,-1,2}));
  }
}