1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4        if (n <= 1 || k <= 0) return 0;
5
6        // 特殊情况优化：如果 k 很大（超过天数的一半），
7        // 那么就退化成了“不限次数交易”（122题），可以直接用贪心。
8        if (k >= n / 2) {
9            int maxProfit = 0;
10            for (int i = 1; i < n; i++) {
11                if (prices[i] > prices[i - 1]) {
12                    maxProfit += prices[i] - prices[i - 1];
13                }
14            }
15            return maxProfit;
16        }
17
18        // 定义状态数组
19        // buy[j] 表示第 j 次买入后的最大收益
20        // sell[j] 表示第 j 次卖出后的最大收益
21        int[] buy = new int[k + 1];
22        int[] sell = new int[k + 1];
23
24        // 初始化：买入状态初始化为负无穷或第一天的负股价
25        for (int j = 0; j <= k; j++) {
26            buy[j] = -prices[0];
27            sell[j] = 0;
28        }
29
30        for (int i = 1; i < n; i++) {
31            for (int j = 1; j <= k; j++) {
32                // 更新第 j 次买入：取“保持现状”或“在上次卖出的基础上买入”
33                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
34                // 更新第 j 次卖出：取“保持现状”或“在这次买入的基础上卖出”
35                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
36            }
37        }
38
39        return sell[k];
40    }
41}