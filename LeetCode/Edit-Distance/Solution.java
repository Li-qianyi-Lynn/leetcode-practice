1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5
6        int[][] dp = new int[m+1][n+1];
7
8        // first row 
9        for (int j = 0; j <= n; j++ ) {
10            dp[0][j] = j;
11
12        }
13
14        for (int i = 0; i <= m; i++ ) {
15            dp[i][0] = i;
16
17        }
18
19        for (int i = 1; i <= m; i++) {
20            for (int j =1; j <= n; j++) {
21                if (word1.charAt(i-1) == word2.charAt(j-1)) {
22                    dp[i][j] = dp[i-1][j-1];
23                } else {
24                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) +1;
25                }
26            }
27        }
28        return dp[m][n];
29        
30    }
31}
32/**
33input: string word1, word2
34output: int min 
35
36insert: add char
37delete: remove char
38replace: 用另外一个char 去换
39
40把前i 个char in word1 换成 前 j 个char in word2
41preoperation: int[m+1][n+1] dp;
421. 需要先比较word1.charat(i) == word2.charAt(j), dp[i][j] = dp[i-1][j-1] operation not change
432. dp[i][j]: 把前i 个char in word1 换成 前 j 个char in word2 所需要的min operations 
44dp[i][j] = math.min()
45
46return dp[m][n]
47
48   empty  r  o  s
49em  0.    1  2.  3.     insert
50
51h.  1.    
52o.  2
53r.  3
54s.  4
55e   5 
56
57  delete
58
59  replace: dp[i-1][j-1] + 1
60  delete: dp[i-1][j] + 1
61  insert: dp[i][j-1] +1
62
63tc: O(m * n)
64sc: O(m * n)
65
66
67
68
69 */