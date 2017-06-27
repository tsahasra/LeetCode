public class MajorityElem {
    public static int majorityElement(int[] nums) {
       int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
    }

  
 public static void main(String[] args){
      System.out.println(majorityElement(new int[]{1,3,4,5,1,6}));
}

}