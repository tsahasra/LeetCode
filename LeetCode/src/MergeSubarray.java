public class MergeSubarray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=n-1,k=m-1;
        
        for(int i= m+n-1;i>=0;i++){
            if(nums1[k] > nums2[j]){
                nums1[i] = nums2[j];
                j--;
            }else
                nums1[i] = nums1[k];
                k--;
        }
        
        
    }

    public static void main(String[] args){
       int[] nums = {1};
       int m=1,n=0;
       merge(nums,m,new int[]{},n); 
     for(int i=0;i<m+n-1;i++)
            System.out.println(nums[i]);
    }
}