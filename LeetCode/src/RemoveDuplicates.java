public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1)
            return 1;
        int len = 1;
        
        for(int i=1;i<nums.length;i++)
            if(nums[i] != nums[i-1]  && i != len){
                nums[len] = nums[i];
                len++;
            }
            
        return len;
    }
    
    public static void main(String[] args){
       System.out.println(removeDuplicates(new int[]{1,1,2,3,3,4,5,6,6}));
   }
}