1class Solution {
2    public int numDecodings(String s) {
3        // edge case
4        if (s.charAt(0) == '0') {
5            return 0;
6        }
7
8        if (s.length() == 1) {
9            return 1;
10        }
11
12        int n = s.length();
13        int[] dp = new int[n+1];
14
15        // init
16        dp[0] = 1;
17
18        for (int i = 1; i < n+1; i++) {
19            // single 
20            if (s.charAt(i-1) != '0') {
21                 dp[i] += dp[i-1];
22            }
23            // double int
24            if (i-2 >= 0) {
25                int doubleInt = Integer.parseInt(s.substring(i-2,i)); //todo
26                if (doubleInt <= 26 && doubleInt >= 10) {
27                    dp[i] += dp[i-2];
28
29                }
30            }
31        }
32        return dp[n];
33        
34    }
35}
36/**
37input: String s
38output: the num of ways to decode s
39
40
41start from 0 can't be decodes
42
43two ways:
44
45single int: 1
46double int: 1
47
48dp/dfs
49
50// single int 
51dp[i] += dp[i-1];
52
53
54// double int 
55// check int -> 10 - 26
56dp[i] += dp[i-2];
57
58
59  0| 2     2   6
60  0  i-2  i-1  i
61
62return dp[i]
63
64
65
66
67 */