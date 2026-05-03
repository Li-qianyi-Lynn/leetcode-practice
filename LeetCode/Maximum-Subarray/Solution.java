1class Solution {
2    public int maxSubArray(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7
8        int[] dp = nums.clone();
9        for (int i = 1; i < nums.length; i++) {
10            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
11        }
12        int maxSum = dp[0];
13        for (int sum : dp) {
14            maxSum = Math.max(maxSum, sum);
15        }
16        return maxSum;
17
18
19        
20        
21    }
22}