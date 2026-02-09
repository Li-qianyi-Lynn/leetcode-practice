1class Solution {
2    int[][] memo; // true 1, false 0, -1 not
3    public boolean isInterleave(String s1, String s2, String s3) {
4        int len1 = s1.length();
5        int len2 = s2.length();
6        int len3 = s3.length();
7        if (len1 + len2 != len3) {
8            return false;
9        }
10        memo =new int[len1+1][len2+1];
11        for (int[] i : memo) {
12            Arrays.fill(i,-1);
13        }
14        return helper(s1, s2, s3, 0,0,0);
15        // 
16    }
17
18    private boolean helper(String s1, String s2, String s3, int i, int j, int k) {
19        int len1 = s1.length();
20        int len2 = s2.length();
21        int len3 = s3.length();
22        // base case
23        boolean res = false;
24        if (i == len1 && j == len2) {
25            return true;
26        }
27
28        if (memo[i][j] != -1) {
29            return memo[i][j] == 1 ? true : false ;
30        }
31
32        if (i < len1 && s1.charAt(i) == s3.charAt(k)) {
33            if (helper(s1, s2, s3, i+1,j,k+1)) {
34                res = true;
35            }
36        }
37
38        if (j < len2 && s2.charAt(j) == s3.charAt(k)) {
39            if (helper(s1, s2, s3, i,j+1,k+1)) {
40                res = true;
41            }
42        }
43
44        if (res == true) {
45            memo[i][j] = 1;
46        } else {
47            memo[i][j] = 0;  
48        }
49        
50        return res;
51    }
52}
53
54/**
55
56input: 3 string
57output: boolean
58
59s3 的每一个字符都是来自于s1/s2 
60pointer: indicate 目前走到了s1/s2/ s3 哪里
61i j k
62
63boolean helper
64base case
65
66i== len1 && j == len2  return true
67
68check memo 是不是-1, 不是-1 return memo[i][j]
69boolean res = false;
70
71
72
73s1: i < len1, s1.charAt(i) == s3.charAt(k)
74helper(i+1, j, k+1) true
75
76s2: j <len2, s2.charAt(j) == s3.charAt(k);
77helper(i,j+1,k+1) true
78
79res = true;
80if res == true, memo[i][j] = 1
81else memo[i][j] = 0
82return res;
83
84
85
86
87
88
89
90
91 */