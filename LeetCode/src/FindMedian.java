public class FindMedian {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length , i= len1/2 , j=len2/2 , n1 = len1%2 , n2 = len2%2;
        
        if(len1 == 0 && len2 != 0)
            if(n2 == 0)
                return ((double)(nums2[j] + nums2[j-1]) / 2.0);
            else
                return nums2[j];
            
                
        if(len1 != 0 && len2 == 0)
            if(n1 == 0)
                return ((double)(nums1[i] + nums1[i-1]) / 2.0);
            else
                return nums2[i];
         
        if(nums1[i] == nums2[j]){
            if((n1 | n2) == 0)
                return ((double) (nums1[i] + Math.max(nums1[i-1],nums2[j-1]))) / 2.0;
            else      
                return (double) nums1[i];
        } 
         else if(nums1[i] > nums2[j]){
             while(i>=0  && j<len2){
                 if(j<len2-1)
                    j++;
                 if(i>=1)
                    i--;
                  if(nums1[i] <= nums2[j]){
                    if(i + j > len1-1-i + len2-1-j)
                    	return ((double) (nums1[i]+nums2[j-1]) / 2.0);
                  }
                    
                  if(i==0){
                	  
                  }
                  
                  if(j==len2-1)
                	  	
                	  break;
                	  
             }
        }
         else{
            while(j>=0  && i<len1){
                 if(i<len1-1)
                    i++;
                 if(j>=1)
                    j--;
                  if(nums1[i] == nums2[j])  
                    return (double) nums1[i];
                  else if(nums1[i] > nums2[j])
                            return ((double) (nums1[i]+nums2[j]) / 2.0);
                  
                  if(j==0 && i==len1-1)
                	  break;
             }
            
            
            	
        }
            
        
        
                    
        return ((double) (nums1[i]+nums2[j]) / 2.0);            
    }

public static void main(String[] args){
    System.out.println(findMedianSortedArrays(new int[]{4,5,6},new int[]{7,8,8,9,9}));
}


}