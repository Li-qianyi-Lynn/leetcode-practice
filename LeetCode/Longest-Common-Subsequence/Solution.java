1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int m = text1.length();
4        int n = text2.length();
5
6        int[][] dp = new int[m+1][n+1];
7        for (int i = 1; i <= m; i++) {
8            char c1 = text1.charAt(i-1);
9            for (int j = 1; j <= n; j++) {
10                char c2 = text2.charAt(j-1);
11                if (c1 == c2) {
12                    dp[i][j] = dp[i-1][j-1]+1;
13
14                } else {
15                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
16
17                }
18
19            }
20
21        }
22        return dp[m][n];
23
24        
25    }
26}
27/**
28
29dp[i][j]
30tex1 i tex2 j common subsequence
31
32  - a b c d e
33-
34a
35
36c
37
38e
39
40char1 == char2 dp[i][j] = dp[i-1][j-1]+1;
41
42!=         dp[i][j] = Math.max(dp[i-1][j]+dp[i][j-1]);
43 */