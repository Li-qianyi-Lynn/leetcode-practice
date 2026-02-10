1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices.length == 1) {
4            return 0;
5        }
6        int profit = 0;
7        int buy = prices[0];
8        for (int i = 1; i < prices.length; i++) {
9            if (prices[i] > buy) {
10                profit = Math.max(profit, prices[i]- buy);
11            } else {
12                buy = prices[i];
13            }
14
15        }
16        return profit;    
17    }
18}
19
20/**
21profit = 0;
22cur = num[0];
23
24nums[i] > cur
25update profit max 4
26
27else 
28cur = nums[i]
29
30 */