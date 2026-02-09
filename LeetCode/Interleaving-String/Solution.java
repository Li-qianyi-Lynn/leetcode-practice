1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {  
3        // pruning
4        int m = s1.length(), n = s2.length();
5        if (m + n != s3.length()) return false;
6
7        // 要考虑空字符串的情况
8        boolean[][] dp = new boolean[m + 1][n + 1];
9        
10        // Base case: 两个空字符串可以组成空字符串
11        dp[0][0] = true;
12
13        // 初始化第一列：只用 s1 拼 s3 的前缀
14        for (int i = 1; i <= m; i++) {
15            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
16        }
17
18        // 初始化第一行：只用 s2 拼 s3 的前缀
19        for (int j = 1; j <= n; j++) {
20            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
21        }
22
23        // 填表
24        for (int i = 1; i <= m; i++) {
25            for (int j = 1; j <= n; j++) {
26                // 当前要匹配的是 s3 的第 i + j - 1 个字符
27                int k = i + j - 1;
28                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) || 
29                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
30            }
31        }
32
33        return dp[m][n];
34    }
35
36}
37
38/**
39我们定义 dp[i][j] 为：s1 的前 i 个字符和 s2 的前 j 个字符，是否能交织组成 s3 的前 i + j 个字符。 (结果是 true 或 false)
40
41当你站在 dp[i][j] 这个格子上时，说明你已经成功拼出了 $s3$ 的前 $i+j$ 个字符。现在你想知道这个状态是怎么来的？只有两种可能：从左边来（用了 $s2$ 的字符）：如果 $s2$ 的第 $j$ 个字符正好等于 $s3$ 的第 $i+j$ 个字符，且之前的状态 dp[i][j-1] 是 true。从上面来（用了 $s1$ 的字符）：如果 $s1$ 的第 $i$ 个字符正好等于 $s3$ 的第 $i+j$ 个字符，且之前的状态 dp[i-1][j] 是 true。只要其中一种成立，dp[i][j] 就是 true。
42
43
44 */