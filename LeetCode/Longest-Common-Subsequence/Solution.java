1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int m = text1.length();
4        int n = text2.length();
5
6        int[][] dp = new int[m+1][n+1];
7        for (int i = 1; i <= m; i++) {
8            char c1 = text1.charAt(i-1);
9            for (int j = 1; j <= n; j++) {
10               
11                char c2 = text2.charAt(j-1);
12
13                if (c1 == c2) {
14                    dp[i][j] = dp[i-1][j-1] + 1;
15
16                } else {
17                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
18                }
19
20            }
21
22        }
23        return dp[m][n];
24        
25        
26        
27    }
28}
29/**
30
31dp
32i：代表 text1 的前 i 个字符（即 text1 中下标从 0 到 i-1 的子串）。
33j：代表 text2 的前 j 个字符（即 text2 中下标从 0 到 j-1 的子串）
34
35匹配上：
36dp[i][j] = dp[i-1][j-1] +1
37
38没匹配上
39放弃 text2 的第 j 个字符，看 text1 的前 i 个字符和 text2 的前 j-1 个字符能匹配多少，即 dp[i][j-1]。
40放弃 text1 的第 i 个字符，看 text1 的前 i-1 个字符和 text2 的前 j 个字符能匹配多少，即 dp[i-1][j]。
41dp[i][j] = Math.max(dp[i-1][j]，dp[i][j-1])
42
43 */