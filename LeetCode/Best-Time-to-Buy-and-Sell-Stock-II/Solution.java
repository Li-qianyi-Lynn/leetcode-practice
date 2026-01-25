1class Solution {
2    public int maxProfit(int[] prices) {
3        // edge case
4        if (prices.length == 1 ) {
5            return 0;
6        }
7
8        int res = 0;
9        for (int i = 1; i < prices.length; i++) {
10            int sell = i;
11            int buy = i-1;
12            if (prices[sell] > prices[buy]) {
13                res += prices[sell] - prices[buy];
14            }
15        }
16        return res;
17        
18    }
19}
20
21/**
22
23input: int[] prices prices[i]: price of ith day
24hold at most one share of the stock, multiple times on one day
25
26output: int  maximum profit you can achieve.
27
28rule:
29price on sell day > price on buy day;  profit += prices[sell] - prices[buy] 
30sell = buy + 1
31
321. for loop to iterate prices
33buy = i
34sell = i+1
35
36profit += prices[sell] - prices[buy] 
37
38 */