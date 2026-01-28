1class Solution {
2    public int maxProfit(int[] prices) {
3        // edge case
4        if (prices.length == 1) {
5            return 0;
6        }
7
8        int profit = Integer.MIN_VALUE;
9        int buy = 0;
10        int sell = 1;
11        while (sell < prices.length) { // diff day
12            if (prices[buy] >= prices[sell]) {
13                buy = sell;
14
15            } else {
16                profit = Math.max(profit, prices[sell]-prices[buy]);
17            }
18            sell++;
19
20
21        }
22        return profit == Integer.MIN_VALUE ? 0 : profit;
23        
24        
25    }
26}
27
28/**
29
30input: int[] prices 
31output: int  maximum profit  or 0
32
33two pointer
34[7,6,4,3,1]
35l
36          r
37if prices[l] >= prices[r];
38move left pointer
39else update profit, move right pointer
40
41[2,1,4]
42l
43     r
44
452
46 */