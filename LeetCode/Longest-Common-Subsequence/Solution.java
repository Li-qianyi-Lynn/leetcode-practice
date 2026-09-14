1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3
4        if (text1.length() < text2.length()) {
5            return longestCommonSubsequence(text2, text1);
6
7        }
8        int m = text1.length();
9        int n = text2.length();
10
11        int[] dp = new int[n+1];
12        for (int i = 1; i <= m; i++) {
13            char c1 = text1.charAt(i-1);
14            int prev = 0; // 记录左上角 dp[i-1][j-1]
15            for (int j = 1; j <= n; j++) {
16                char c2 = text2.charAt(j-1);
17                int temp = dp[j]; // 暂存当前的 dp[j]（即上一行的 dp[i-1][j]）
18                if (c1 == c2) {
19                    dp[j] = prev +1;
20
21                } else {
22                    dp[j] = Math.max(dp[j], dp[j-1]);
23
24                }
25
26                prev = temp;
27
28            }
29
30        }
31        return dp[n];
32
33        
34    }
35}
36/**
37
38dp[i][j]
39tex1 i tex2 j common subsequence
40
41  - a b c d e
42-
43a
44
45c
46
47e
48
49char1 == char2 dp[i][j] = dp[i-1][j-1]+1;
50
51!=         dp[i][j] = Math.max(dp[i-1][j]+dp[i][j-1]);
52 */