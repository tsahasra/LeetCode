import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
    	if(nums.length <3)
            return new ArrayList<List<Integer>>();
            
        int len = nums.length , max = 0;
        Arrays.sort(nums);
        
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        for(int i=len-1;nums[i]>=0 && i>= 2;i--){
            if(i<len-1 && nums[i] == nums[i+1])
                continue;
            for(int j =0,k=i-1;j<k;)
                if(nums[j] + nums[k] > -nums[i]){
                    while(k !=0 && nums[k] == nums[k-1])
                      k--;
                      k--;
                }else if (nums[j] + nums[k] < -nums[i]){
                    while(j != i-1 && nums[j] == nums[j+1])
                      j++;
                      j++;
                }else{
                    List<Integer> temp= new ArrayList<Integer>();
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    li.add(temp);
                    while(k !=0 && nums[k] == nums[k-1])
                      k--;
                      k--;
                    while(j != i-1 && nums[j] == nums[j+1])
                      j++;
                      j++;
                }
                            
        }
            
        return li;
    }

  public static void main(String[] args){
     System.out.println(threeSum(new int[]{0,0,0}));
}   
}