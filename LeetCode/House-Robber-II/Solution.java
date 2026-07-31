1class Solution {
2    public int rob(int[] nums) {
3        if (nums == null || nums.length == 0) return 0;
4        int n = nums.length;
5        if (n == 1) return nums[0];
6
7        // 场景一：只考虑区间 [0, n - 2]
8        int max1 = robRange(nums, 0, n - 2);
9        // 场景二：只考虑区间 [1, n - 1]
10        int max2 = robRange(nums, 1, n - 1);
11
12        // 返回两者的最大值
13        return Math.max(max1, max2);
14    }
15
16    // 标准线性 DP
17    private int robRange(int[] nums, int start, int end) {
18        int len = end - start + 1;
19        if (len == 1) return nums[start];
20
21        // dp[j] 表示在当前子区间内，考虑前 j 个房子能拿到的最大金额
22        int[] dp = new int[len];
23
24        // 基础状态初始化
25        dp[0] = nums[start];
26        dp[1] = Math.max(nums[start], nums[start + 1]);
27
28        // 状态转移
29        for (int i = 2; i < len; i++) {
30            // 当前元素在 nums 中的实际索引是 start + i
31            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
32        }
33
34        return dp[len - 1];
35    }
36}
37/**
38$$dp[i] = \max(dp[i-1],\, dp[i-2] + nums[i])$$
39
40 */