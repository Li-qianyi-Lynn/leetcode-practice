1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int res = 0;
5
6        for (int i = 1; i < n; i++) {
7            if (prices[i] > prices[i-1]) {
8                res += prices[i] - prices[i-1];
9
10            }
11
12        }
13        return res;
14
15
16        
17    }
18}