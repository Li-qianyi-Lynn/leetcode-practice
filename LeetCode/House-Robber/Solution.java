1class Solution {
2    public int rob(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7
8        int[] dp = new int[nums.length];
9        dp[0] = nums[0];
10        dp[1] = Math.max(nums[0], nums[1]);
11        for (int i = 2; i < nums.length; i++) {
12            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
13        }
14        return dp[nums.length-1];
15
16        
17    }
18}
19/**
20dp[i] = max(dp[i-1], dp[i-2]+nums[i])
21
22 */