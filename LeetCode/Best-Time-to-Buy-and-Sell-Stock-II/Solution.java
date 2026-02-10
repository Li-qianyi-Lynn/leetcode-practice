1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices.length == 1) {
4            return 0;
5        }
6
7        int profit = 0;
8        int n = prices.length;
9        for (int i = 1; i < n; i++) {
10            if (prices[i] > prices[i-1]) {
11                profit += prices[i] - prices[i-1];
12            }
13
14        }
15        return profit;
16        
17    }
18}
19/**
20
21profit = 0
22
231 5 2 3 2 6
244 4 8
25 */