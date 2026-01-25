1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices.length == 0) {
4            return 0;
5
6        }
7        int res = 0;
8        int buy = 0;
9        int sell = 1;
10        while (sell < prices.length) {
11            if (prices[sell] > prices[buy]) {
12                res += prices[sell] - prices[buy];
13            }
14            buy++;
15            sell++;
16            
17
18        }
19        return res;
20        
21    }
22}
23
24/**
25profit  += prices[sell] - prices[buy]
26
27 */