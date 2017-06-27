import java.util.Arrays;

public class ContainsDuplicates{

public static boolean binarySearch(int[] nums, int s , int e){
        int m = s + (e-s) / 2;
        if(m == 0 || m == nums.length)
        	return false;
        
        if(m>0 && (nums[m+1] == nums[m] || nums[m-1] == nums[m]))
            return true;
        
        if(binarySearch(nums,s,m))
        	return true;
        else
            return binarySearch(nums,m+1,e);
                
        
        }
    
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        return binarySearch(nums,0,nums.length)? true:false;
    }

public static void main(String[] args){
      System.out.println(containsDuplicate(new int[]{1,2,3,4,5,5}));
}

}