import java.util.TreeSet;

public class Dup3 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<=0 || nums.length == 0)
            return false;
        
        TreeSet<Integer> ts = new TreeSet<Integer>();
        int l = nums.length;
        
        for(int i=0;i<l;i++){
            Integer high = ts.floor(nums[i]+t);
            Integer low = ts.ceiling(nums[i]-t);
            
            if((high != null && high >= nums[i]) || (low != null && low <= nums[i]))
                return true;
            
            ts.add(nums[i]);
            if(i>=k)
                ts.remove(nums[i-k]);
        }
        
        return false;
    }

 public static void main(String[] args){
      System.out.println(containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647},3,3));
}
}