1class Solution {
2    public int countSubstrings(String s) {
3        int res = 0;
4        int n = s.length();
5        // find mid point
6        for (int i = 0; i < n; i++) {
7            res += expand(s,i,i);
8            res += expand(s,i,i+1);
9
10        }
11        return res;
12
13
14        
15    }
16    // find how many palindromes
17    private int expand(String s, int l, int r) {
18        int count = 0;
19        
20        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
21            count ++;
22            l--;
23            r++;
24        }
25       
26        return count;
27    }
28}
29/**
30
31odd
32even
33find mid point
34isPalindromic?
35yes -count
36
37res = odd + even
38
39 */