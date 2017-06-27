import java.util.Arrays;

public class MinPairSum {
	
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length , sum =0;
        
        for(int i =0 ; i<len ; i = i + 2 ){
        	int t = nums[i];
            sum = sum + t;
        }
        
        return sum;
    }

    public static void main(String[] args){
    	System.out.println(arrayPairSum(new int[]{1,4,3,2}));
    }
}