import java.util.Arrays;

public class TriangleTriplets {
    public static int triangleNumber(int[] nums) {
        if(nums.length < 3)
                return 0;
                
        Arrays.sort(nums);
        int len = nums.length,count=0;
        
        for(int i=len-1;i>=2;i--)
            for(int j=0;j<=i-2;j++)
                for(int k=j+1;k<i;k++)
                    if(nums[i] == ((nums[i]+nums[j]+nums[k])/2 ) && (((nums[i]+nums[j]+nums[k])/2 == nums[i]) && (nums[i]+nums[j]+nums[k])%2 == 1))
                            count++;
        
        
        return count;
    }

   public static void main(String[] args){
    System.out.println(triangleNumber(new int[]{1,2,3,4,5,6}));
}


}