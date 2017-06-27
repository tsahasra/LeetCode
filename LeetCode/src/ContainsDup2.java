import java.util.ArrayList;
import java.util.List;

public class ContainsDup2 {
    public static  boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<=0 || nums.length == 1)
            return false;
        
        List<Integer> li = new ArrayList<Integer>();
        
        int temp = (nums.length - 1 >= k)?nums.length-1-k:0;
        
        for(int i=nums.length-2;i>=temp;i--)
            li.add(nums[i]);
            
         if(li.contains(nums[nums.length-1]))
            return true;
        
        
        for(int i=nums.length-2;i>=1;i--){
           li.remove(0);
            if(i-k>=0){
                li.add(nums[i-k]);
            }
            if(li.contains(nums[i]))
               return true;
        }
        
        return false;
    }

  public static void main(String[] args){
          System.out.println(containsNearbyDuplicate(new int[]{0,1,2,3,4,5,0}, 5));
 }

}