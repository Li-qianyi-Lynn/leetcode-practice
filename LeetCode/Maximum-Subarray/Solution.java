1class Solution {
2    public int maxSubArray(int[] nums) {
3        if (nums.length == 0) {
4            return 0;
5
6        }
7        int n = nums.length;
8        int[] dp = new int[n];
9        dp[0] = nums[0];
10        int res = dp[0];
11        // dp[i] = Math.max(num,dp[i-1]+ num)
12        for (int i = 1; i < n; i++) {
13            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
14            res = Math.max(dp[i],res);
15
16        }
17        return res;
18
19        
20
21        
22    }
23}