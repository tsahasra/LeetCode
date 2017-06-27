public class removeElem {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length-1,i=len,j=0;
        while(j<=i){
            if(nums[i] == val){
                i--;
                continue;
            }
            if(nums[j]==val){
                nums[j] = nums[i];
                nums[i] = val;
                i--;
                j++;
            }
            else
                j++;
            
          }    
        
        return j;
    }

public static void main(String[] args){
      System.out.println( removeElement(new int[]{1},1));
}
}