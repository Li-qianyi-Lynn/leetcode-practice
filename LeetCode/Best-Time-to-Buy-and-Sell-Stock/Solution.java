1class Solution {
2    public int maxProfit(int[] prices) {
3        int maxP = 0;
4        int buy = 0;
5        int sell = 1;
6
7        while (sell < prices.length) {
8            if (prices[buy] < prices[sell]) {
9                int profit = prices[sell] - prices[buy];
10                maxP = Math.max(profit, maxP);
11
12            } else {
13                buy = sell;
14
15            }
16            sell ++;
17
18        }
19
20        return maxP;
21        
22    }
23}