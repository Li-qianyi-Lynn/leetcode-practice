1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int[][][] dp = new int[n][3][2];
5
6        // day 0:
7        for (int i = 1; i <= 2; i++) {
8            dp[0][i][0] = -prices[0]; // buy
9            dp[0][i][1] = 0;// sell
10        }
11
12        for (int i = 1; i < n; i++) {
13            // 1st time
14            dp[i][1][0] = Math.max(dp[i-1][1][0], -prices[i]);
15            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i][1][0]+prices[i]);
16
17            //2nd time
18            dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i][1][1]-prices[i]);
19            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i][2][0]+ prices[i]);
20
21        }
22        return dp[n-1][2][1];
23        
24    }
25}
26
27/**
28dp 
29n = prices.length-1
30days | times | status
31int[][][] dp = new int[n][2][2]
32
33day1:
34
35other days;
36
37
38
39 */