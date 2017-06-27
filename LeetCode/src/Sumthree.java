import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Tejas
 *
 */
public class Sumthree {
	
    
	public List<List<Integer>> threeSum(int[] nums) {
        
	     int i =0, start = 0 , end = nums.length - 1 , cursor = 1;
	     boolean flag = false;
	     
	     List<List<Integer>> lit = new ArrayList<List<Integer>>();
	     
	     Arrays.sort(nums);
	    
	   
	    while(start < end)
	    {
	        
	    for(i=0 ; i<nums.length; i++)
	     {
	         
	        if(i != start && i != end && (nums[start] + nums[i] + nums[end]) == 0  )
	         {
	             
	             lit.add(Arrays.asList(nums[start],nums[i],nums[end]));
	         }
	         else if(i != start && i != end && (nums[start] + nums[i] + nums[end]) > 0 )
	         {
	             break;
	         }
	         
	        
	         
	     }
	     start++;
	     end --;       
	    }
	    
	         
	   
	    return lit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sumthree st = new Sumthree();
		int[] nums = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> lit = st.threeSum(nums);
		Iterator<List<Integer>> it = lit.iterator();
		while (it.hasNext())
		{
			List<Integer> li1 = it.next();
			Iterator<Integer> it1 = li1.iterator();
			while(it1.hasNext())
				System.out.print(it1.next()+" ");
			System.out.println();
		
		}
	}

}
