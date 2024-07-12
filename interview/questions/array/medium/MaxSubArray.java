package interview.questions.array.medium;

public class MaxSubArray {

    /**
     * Time complexity O(n) because we are accaessing each element in linear fashiom
     * Space complexity O(1) extra space is being used by variables only like curr_sum & max_sum
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int curr_sum = 0 , max_sum = Integer.MIN_VALUE;
        for (int num : nums) {
            if(curr_sum < 0)
                curr_sum = 0;
            curr_sum = curr_sum + num;
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
    public static void main(String [] args){
        int [] nums = new int []{-2,1,-3,4,-1,2,1,-5,4};
//        int [] nums = new int []{-2,-1};
        MaxSubArray obj = new MaxSubArray();
        int maxSumFromSubArr = obj.maxSubArray(nums);
        System.out.print(" Maximum sum = "+maxSumFromSubArr);
    }
}
