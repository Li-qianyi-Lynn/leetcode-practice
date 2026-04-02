1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5
6        int[][] dp = new int[m+1][n+1];
7
8        for (int j = 0; j <= n; j++ ) {
9            dp[0][j] = j;
10
11        }
12        for (int i = 0; i <= m; i++) {
13            dp[i][0] = i;
14        }
15
16        for (int i = 1; i <= m; i++) {
17            for (int j = 1; j <= n; j++) {
18                char a = word1.charAt(i-1);
19                char b = word2.charAt(j-1);
20                if (a == b) {
21                    dp[i][j] = dp[i-1][j-1];
22                } else {
23                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) +1;
24                }
25
26            }
27
28        }
29        return dp[m][n];
30        
31    }
32}
33/**
34
35replace: dp[i][j] = dp[i-1][j-1];
36remove: dp[i][j] = dp[i-1][j] 
37insert: dp[i][j] = dp[i][j-1] 
38word1 的前 i 个字符 转换成 word2 的前 j 个字符 所需的最少操作数。
39
40insert:
41
42
43   h o r s e 
44r
45o
46s
47
48
49 */