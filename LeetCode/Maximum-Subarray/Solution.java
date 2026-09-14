1class Solution {
2    public int maxSubArray(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7        int n = nums.length;
8        int[] dp = new int[n];
9        dp[0] = nums[0];
10        int res = nums[0];
11        for (int i = 1; i < n; i++) {
12            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
13            res = Math.max(dp[i],res);
14
15
16        }
17        return res;
18
19
20        
21    }
22}