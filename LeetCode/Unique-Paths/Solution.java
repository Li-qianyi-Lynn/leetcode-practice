1class Solution {
2    public int uniquePaths(int m, int n) {
3        // 创建一个二维数组来存储到达每个格子的路径数
4        int[][] dp = new int[m][n];
5
6        // 1. 初始化第一行和第一列
7        // 机器人只能向右或向下，所以第一行和第一列的路径数永远是 1
8        for (int i = 0; i < m; i++) dp[i][0] = 1;
9        for (int j = 0; j < n; j++) dp[0][j] = 1;
10
11        // 2. 填充剩余的格子
12        for (int i = 1; i < m; i++) {
13            for (int j = 1; j < n; j++) {
14                // 当前格子的路径数 = 上方格子路径数 + 左方格子路径数
15                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
16            }
17        }
18
19        // 3. 返回右下角的值
20        return dp[m - 1][n - 1];
21    }
22}