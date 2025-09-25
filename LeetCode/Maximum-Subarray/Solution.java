class Solution {
    public int maxSubArray(int[] nums) {
        

        int maxSum = nums[0];
        if (nums.length == 1) {
            return maxSum;

        }
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // 当前位置的最大子数组和
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大值
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;


        
        
    }
}