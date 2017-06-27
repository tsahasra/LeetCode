public class PredictWin {
    public static boolean PredictTheWinner(int[] nums) {
        return (calculateSum(nums,0,nums.length-1) >= 0);
    }
    
    private static int calculateSum(int[] nums , int s , int e){
        return s==e? nums[e] : Math.max(nums[e]-calculateSum(nums,s,e-1),nums[s]-calculateSum(nums,s+1,e));
    }

 public static void main(String[] args){
        System.out.println(PredictTheWinner(new int[]{1,5,2,9}));
}
}