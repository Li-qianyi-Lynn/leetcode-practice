1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices.length == 1) {
4            return 0;
5
6        }
7        int total = 0;
8        for (int i = 1; i < prices.length; i++) {
9            if (prices[i]> prices[i-1]) {
10                total += prices[i]- prices[i-1];
11
12            }
13
14        }
15        return total;
16    
17
18    }
19}
20
21/**
22buy and sell multiple times
23[7,1,5,3,6,4]
24
25[1,2,2,4,5]
26total += diff 
27
28
29
30
31
32 */