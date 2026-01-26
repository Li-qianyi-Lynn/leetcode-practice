1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4
5        // // 如果 k 超过天数一半，退化为贪心算法（不限次数交易）
6        // if (k >= n / 2) {
7        //     int res = 0;
8        //     for (int i = 1; i < n; i++) {
9        //         if (prices[i] > prices[i-1]) {
10        //             res += prices[i] - prices[i-1];
11        //         }
12        //     }
13        //     return res;
14        // }
15
16        // dp[days][k+1][buy or sell]
17        int[][][] dp = new int[n][k + 1][2];
18
19        // day 0
20        for (int j = 0; j <= k; j++) {
21            dp[0][j][0] = -prices[0];// buy
22            dp[0][j][1] = 0;  // sell
23        }
24
25        for (int i = 1; i < n; i++) { // n days
26            for (int j = 1; j <= k; j++) { // k transactions
27                
28                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] - prices[i]);
29                
30                
31                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] + prices[i]);
32            }
33        }
34
35        return dp[n-1][k][1];
36    }
37}