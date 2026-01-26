1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int len = prices.length;
4        
5        int[][][] dp = new int[len][k+1][2]; //days | times | status
6
7        //pruning
8        if (k > len/2) { //limited times, use greedy
9            int total = 0;
10            for (int i = 1; i < len; i++) {
11                if (prices[i] > prices[i-1]) { // can make a profit
12                    total += prices[i] - prices[i-1];
13                }
14            }
15            return total;
16
17        }
18        
19        
20        // day0 
21
22        for (int i = 0; i < k+1; i++) {
23            dp[0][i][0] = -prices[0]; // after bought what i have
24            dp[0][i][1] = 0;  // sold
25        }
26
27        for (int i = 1; i< len; i++) { // for days
28            for (int j = 1; j < k+1; j++) { // for transactions
29                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]-prices[i]);
30                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i][j][0]+prices[i]);
31            }
32
33        }
34        return dp[len-1][k][1];
35
36        
37    }
38}
39
40/**
41input:
42-k: only k transactions
43-int[] prices
44
45output: 
46int: max profit
47
48dp: status change, profit is only depends on the previous status
49
50
51 */