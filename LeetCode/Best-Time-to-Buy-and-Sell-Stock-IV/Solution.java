1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4        if (n == 0 || k == 0) return 0;
5
6        // 如果 k 超过天数一半，退化为贪心算法（不限次数交易）
7        if (k >= n / 2) {
8            int res = 0;
9            for (int i = 1; i < n; i++) {
10                if (prices[i] > prices[i-1]) res += prices[i] - prices[i-1];
11            }
12            return res;
13        }
14
15        // dp[天数][交易次数][持股状态]
16        int[][][] dp = new int[n][k + 1][2];
17
18        // 初始化第一天
19        for (int j = 0; j <= k; j++) {
20            dp[0][j][0] = 0;           // 第0天不持股，利润0
21            dp[0][j][1] = -prices[0];  // 第0天买入，利润为负
22        }
23
24        for (int i = 1; i < n; i++) {
25            for (int j = 1; j <= k; j++) {
26                // 更新“持股”状态：昨天就持有，或今天刚买入（基于第 j-1 次交易后的利润）
27                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
28                
29                // 更新“不持股”状态：昨天就没持，或今天刚卖出（基于第 j 次买入后的利润）
30                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
31            }
32        }
33
34        return dp[n-1][k][0];
35    }
36}