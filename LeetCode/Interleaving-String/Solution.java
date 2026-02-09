1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3    if (s1.length() + s2.length() != s3.length()) return false;
4    
5    // 确保 n 是较小的那个，可以更省空间
6    int n = s2.length();
7    boolean[] dp = new boolean[n + 1];
8    dp[0] = true;
9
10    for (int i = 0; i <= s1.length(); i++) {
11        for (int j = 0; j <= n; j++) {
12            int p = i + j - 1;
13            if (i > 0) {
14                // 这里的 dp[j] 还没更新，存的是 dp[i-1][j] (上方)
15                dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
16            }
17            if (j > 0) {
18                // 这里的 dp[j-1] 已经更新了，存的是 dp[i][j-1] (左方)
19                dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
20            }
21        }
22    }
23    return dp[n];
24}
25}