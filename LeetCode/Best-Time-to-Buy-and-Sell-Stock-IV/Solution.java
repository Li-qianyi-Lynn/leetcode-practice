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
16        }
17          
18        // day0 
19        for (int i = 0; i < k+1; i++) {
20            dp[0][i][1] = -prices[0];  // hold
21            dp[0][i][0] = 0; // unhold
22
23        }
24
25        for (int i = 1; i< len; i++) { // for days
26            for (int j = 1; j < k+1; j++) { // for transactions
27                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
28                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
29
30            }
31
32        }
33        return dp[len-1][k][0];
34  
35    }
36}
37
38/**
39input:
40-k: only k transactions
41-int[] prices
42
43output: 
44int: max profit
45
46dp: status change, profit is only depends on the previous status
47
48
49 */