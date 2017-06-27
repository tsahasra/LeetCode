import java.util.Arrays;

public class Sum2Closest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length,high = len-1, i =0,j=len-2;
        int sum = nums[high] + nums[i] + nums[j];
        
        while(high >= 2){
            for(i =0,j=high-1;i<j ;){
                int temp = nums[high] + nums[i] + nums[j];
                if(Math.abs(target - temp) < Math.abs(target - sum))
                    sum = temp;
                if(temp > target)
                    j--;
                else if(temp < target)
                    i++;
                else
                	return target;
                
            }
            
            high--;
            
        }
        
        return sum;
    }

public static void main(String[] args){
     System.out.println(threeSumClosest(new int[]{-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33},0));
}  
}