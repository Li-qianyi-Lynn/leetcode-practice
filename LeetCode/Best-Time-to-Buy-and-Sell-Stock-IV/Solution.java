1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4        // days | times | status
5        int[][][] dp= new int [n][k+1][2];
6
7        if (k > n/2) { //no limited use greedy
8            int total = 0;
9            for (int i = 1; i < n; i++) {
10                if (prices[i] > prices[i-1]) {
11                    total += prices[i] - prices[i-1];
12                }
13
14            }
15            return total;
16        }
17
18        //day0
19        for (int i = 0; i < k+1; i++) {
20            dp[0][i][0] = -prices[0]; //buy
21            dp[0][i][1] = 0; // sell
22
23        }
24
25        for (int i = 1; i < n; i++) {
26            for (int j = 1; j < k+1;j++) {
27                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]-prices[i]); // buy: 上一次卖完剩下的钱再买
28                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i][j][0] + prices[i]);  // sell
29
30            }
31
32        }
33        return dp[n-1][k][1];
34        
35    }
36}