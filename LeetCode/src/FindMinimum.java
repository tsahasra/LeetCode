public class FindMinimum {
    public static  int findMin(int[] nums) {
        if(nums.length == 0)
            return 0;
            
        if(nums.length == 1)
            return nums[0];
        
            
        int len = nums.length , low = 0, high = len -1,mid = 0 ;
        
        while(low < high){
            mid = low + (high-low) / 2;
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            
            if(mid < len -1 && nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid] > nums[high])
                low = mid +1;
            else
               high = mid -1;
        
        }  
        
        return nums[0];
    }
    
public static void main(String[] args){
     System.out.println(findMin(new int[]{4,5,6,7,8,9,12}));
}   

}