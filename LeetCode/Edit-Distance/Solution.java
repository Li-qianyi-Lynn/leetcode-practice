1class Solution {
2    int[][] memo;
3    public int minDistance(String word1, String word2) {
4        
5        int m = word1.length();
6        int n = word2.length();
7        memo = new int[m+1][n+1];
8        for (int[] i : memo) {
9            Arrays.fill(i,-1);
10
11        }
12
13  
14        return helper(word1, word2,m,n);
15
16         
17        
18    }
19
20    private int helper(String word1, String word2, int r, int c) {
21        if (r == 0) {
22            return c;
23
24        }
25        if (c == 0) {
26            return r;
27
28        }
29
30        if (memo[r][c] != -1) {
31            return memo[r][c];
32
33        }
34
35        int res;
36        if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
37            res = helper(word1, word2, r - 1, c - 1);
38        } else {
39            int replace = helper(word1, word2, r - 1, c - 1); 
40            int insert  = helper(word1, word2, r, c - 1);     
41            int delete  = helper(word1, word2, r - 1, c);     
42            
43            res = Math.min(replace, Math.min(insert, delete)) + 1;
44        }
45
46        memo[r][c] = res;
47        return res;
48
49    }
50}
51
52/**
53通过一个二维表格，把大问题拆解成三个小动作（增、删、改）的最小值，通过局部最优推导出全局最优
54replace: dp[i][j] = dp[i-1][j-1] +1
55insert:   dp[i][j] = dp[i][j-1] +1 
56delete:  dp[i][j] = dp[i-1][j] +1
57
58
59
60target    / r o s
61        / 0 1 2 3 
62        h 1 
63        o 2
64        r 3
65        s 4
66        e 5
67
68
69 */