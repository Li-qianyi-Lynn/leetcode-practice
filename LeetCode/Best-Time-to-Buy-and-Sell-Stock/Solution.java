1class Solution {
2    public int maxProfit(int[] prices) {
3        int res = 0;
4        int buyPrice = prices[0];
5        for (int i = 1; i < prices.length; i++) {
6            int sellPrice = prices[i];
7            if (sellPrice > buyPrice) {
8                res = Math.max(res, sellPrice-buyPrice);
9
10            } else {
11                buyPrice = sellPrice;
12            }
13
14        }
15        return res;
16    }
17}
18/**
19
20sell price
21buy price
22
23 */