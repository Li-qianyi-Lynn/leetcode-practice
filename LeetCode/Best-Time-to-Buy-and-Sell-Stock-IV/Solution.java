1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4        // days | times | status
5        int[][][] dp= new int [n][k+1][2];
6
7        //day0
8        for (int i = 0; i < k+1; i++) {
9            dp[0][i][0] = -prices[0]; //buy
10            dp[0][i][1] = 0; // sell
11
12        }
13
14        for (int i = 1; i < n; i++) {
15            for (int j = 1; j < k+1;j++) {
16                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]-prices[i]); // buy
17                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i][j][0] + prices[i]);  // sell
18
19            }
20
21        }
22        return dp[n-1][k][1];
23        
24    }
25}