1class Solution {
2    public int rob(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7        int n = nums.length;
8        int[] dp = new int[n];
9        dp[0] = nums[0];
10        dp[1] = Math.max(nums[1], nums[0]);
11        for (int i = 2; i < n; i++) {
12            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[i]);
13
14        }
15        return dp[n-1];
16
17        
18    }
19}
20/**
21
22dp[]: max money
23
24
25
26
27
28 */