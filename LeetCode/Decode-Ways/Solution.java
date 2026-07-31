1class Solution {
2    public int numDecodings(String s) {
3        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
4            return 0;
5        }
6
7        int n = s.length();
8        int[] dp = new int[n + 1];
9
10        // 基础状态
11        dp[0] = 1; // 空字符串
12        dp[1] = 1; // 第一个字符不为 '0'，只有 1 种解法
13
14        for (int i = 2; i <= n; i++) {
15         
16            char single = s.charAt(i - 1);
17            int doubleNum = Integer.parseInt(s.substring(i - 2, i));
18
19            // 1. 尝试单独解码第 i 个字符
20            if (single != '0') {
21                dp[i] += dp[i - 1];
22            }
23
24            // 2. 尝试与前一个字符组合解码（范围必须在 10 ~ 26）
25            if (doubleNum >= 10 && doubleNum <= 26) {
26                dp[i] += dp[i - 2];
27            }
28        }
29
30        return dp[n];
31    }
32}