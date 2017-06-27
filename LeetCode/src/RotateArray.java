public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1)
            return;
            
        int j = 0 , len = nums.length;
        
        if(k > len){
            k = k % len;
        	if(k == 0)
        		return;
        }
        
        int count = 0 , di = 0 , ti = 0 , temp=nums[ti],dval=0;
        while(count < len){
        	if(ti+k > len - 1)
        		di = ti+k - len;
        	else
        		di = ti+k;
        dval = nums[di];
        nums[di] = temp;
        ti = di;
        temp = dval;
        count++;
        }
    }

   public static void main(String[] args){
	   int[] nums = new int[]{1,2,3,4,5,6};
	   rotate(nums, 4);
	   for(int i =0;i<nums.length;i++)
		   System.out.print(nums[i]+",");
   }
}