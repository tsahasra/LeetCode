public class ConvertToBST {
    
    public static TreeNode createBST(int[] nums , int s , int e){
    	if(e+1-s == 0)
    		return null;
    	
    	if(e+1-s == 1)
            return new TreeNode(nums[s]);
        
        TreeNode head ;
        
        
        int rootin = 0;
        
        if((e+1-s) % 2 == 1){
        	rootin = (s + ((e+1-s) / 2 )) ;
        	
        }else{
        	rootin = (s + ((e+1-s) / 2)) - 1;
        	
        }
        
        head = new TreeNode(nums[rootin]);            
        head.left = createBST(nums,s,rootin-1);
        head.right = createBST(nums,rootin+1,s + ((e+1-s)-1));
        
        return head;   
    }
    
    public static TreeNode sortedArrayToBST(int[] nums) {
       
        if(nums.length == 0)
            return null;
            
        TreeNode head = createBST(nums,0,nums.length-1);
         
        return head;
    }
    
    
   public static void printTree(TreeNode head){
	   if(head== null || (head.left == null && head.right == null))
		   return;
	   
	   if(head.left==null)	
		   System.out.print(",null");
	   else{
		   System.out.print(","+head.left.val);
		      
	   }
	   
	   if(head.right==null)	
		   System.out.print(",null");
	   else{
		   System.out.print(","+head.right.val);
		      
	   }
	   
	   printTree(head.left);
	   printTree(head.right);
   }

   public static void main(String[] args){
	 TreeNode head =  sortedArrayToBST(new int[]{1,1,2,3,3,4,4,8,8});
	   
	 System.out.print(head.val);
	 printTree(head);
   }
}