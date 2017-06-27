import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class KDiff {
    public static int findPairs(int[] nums, int k) {
    	if(nums.length == 0 || k<0)
            return 0;
            
       HashMap<Integer,Integer> li = new HashMap<Integer,Integer>();
        
        int count =0 , len = nums.length , i = 0 ;
        
        for(i=0;i<len;i++)
            if(!li.containsKey(nums[i]))
                li.put(nums[i],1);
            else
                li.put(nums[i],li.get(nums[i])+1);   
                
         Set<Integer> se = li.keySet();       
        
            if(k == 0){
                for(Integer i1 : se)
                    if(li.get(i1) >= 2)
                        count++;
            }else{
                for(Integer i2 : se)
                    if(li.containsKey(i2+k))
                        count++;
            }
        
            
        return count;
    }
    
    public static void main(String[] args){
        System.out.println(findPairs(new int[]{3,1,4,1,5},0));
        }
    }