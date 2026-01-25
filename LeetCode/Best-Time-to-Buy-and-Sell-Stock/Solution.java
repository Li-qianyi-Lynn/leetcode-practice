1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices.length == 1) {
4            return 0;
5        }
6        int buy = 0;
7        int sell = 1;
8        int profit = 0;
9        while (sell < prices.length) {
10            if (prices[sell] > prices[buy]) {
11                profit = Math.max(prices[sell]- prices[buy], profit);
12            } else {
13                buy = sell;
14            }
15            sell++;
16
17        }
18        return profit;
19
20        
21        
22    }
23}
24
25
26/*
27buy:0
28sell:1
29if prices[sell] > prices[buy] update profit, sell ++
30else sell = buy
31*/
32
33
34
35