1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5        
6        // dp[i][j] 表示 word1[0...i-1] 转换为 word2[0...j-1] 的步数
7        int[][] dp = new int[m + 1][n + 1];
8        
9        // Base Case: 如果 word2 为空，word1 需要全部删除
10        for (int i = 0; i <= m; i++) {
11            dp[i][0] = i;
12        }
13        // Base Case: 如果 word1 为空，word1 需要全部插入
14        for (int j = 0; j <= n; j++) {
15            dp[0][j] = j;
16        }
17        
18        for (int i = 1; i <= m; i++) {
19            for (int j = 1; j <= n; j++) {
20                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
21                    // 字符相同，继承左上角的值
22                    dp[i][j] = dp[i - 1][j - 1];
23                } else {
24                    // 字符不同，取 (替换, 删除, 插入) 三者最小值 + 1
25                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], 
26                                   Math.min(dp[i - 1][j], dp[i][j - 1]));
27                }
28            }
29        }
30        
31        return dp[m][n];
32    }
33}