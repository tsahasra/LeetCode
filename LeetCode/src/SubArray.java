public class SubArray {
    public static int findUnsortedSubarray(int[] nums) {
        
        int nlen = nums.length , minindex = nlen-1 , maxindex = 0 , s = 0 , e= -1 ,i=1,len=0;
        boolean flag = false;
        
        for(i=0;i<nlen;i++){
            if(nums[i] < nums[0]){
                s = 0;
                break;
            }
            
            
			if(nums[i] < nums[maxindex])
                if(!flag){
                	s = maxindex;
                	flag = true;
                }
                
            if(!flag && nums[i] > nums[maxindex])
                maxindex = i;
                
        }
        
        flag = false;
        
        for(i=nlen-1;i>=0;i--){
            
            if(nums[i] > nums[nlen-1]){
                e = nlen-1;
                break;
            }
            
            if(nums[i] > nums[minindex])
            	if(!flag){
            		e = minindex;
            		flag = true;
               }
            
            if(!flag && nums[i] < nums[minindex])
                minindex = i;
        }
                
        return e-s+1;
    }
    
    public static void main(String[] args){
    	System.out.println(findUnsortedSubarray(new int[]{1,2,4,5,3,7}));
    }
    
}