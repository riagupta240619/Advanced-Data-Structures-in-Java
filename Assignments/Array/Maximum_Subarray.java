package Array;

public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int val: nums){
            curr_sum += val;
            max_sum = Math.max(curr_sum, max_sum);
            if(curr_sum<0){
                curr_sum = 0;
            }
        }
        return max_sum;
    }
    public static void main(String[] args){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
