1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        if (n == 0) return 0;
5
6        // dp[天数][交易次数][是否持股]
7        int[][][] dp = new int[n][3][2];
8
9        // 初始化第一天
10        for (int k = 0; k <= 2; k++) {
11            dp[0][k][0] = -prices[0]; // buy
12            dp[0][k][1] = 0; // sell
13            
14        }
15
16        for (int i = 1; i < n; i++) {
17            // 第 1 次交易
18            
19            dp[i][1][0] = Math.max(dp[i-1][1][0], -prices[i]); // buy
20            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0] +prices[i]); // sell
21
22
23            // 第 2 次交易
24            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][1] - prices[i]);
25            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][2][0] + prices[i]);
26        }
27
28        return dp[n-1][2][1];
29    }
30}
31
32
33/**
34dp
35divided the whole process into four status, the goal: get the most money
36buy1: after first buy, the money i have max(buy1, -p) 
37sell1: after first sell, the money i have max(sell1, buy1 +p) 
38buy2: .. max(buy2, sell1 - p)
39sell2: .. max(sell2, buy2 + p )
40
41
42 */