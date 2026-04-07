1class Solution {
2    public int maxVowels(String s, int k) {
3        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
4        int n = Math.min(s.length(),k);
5        int cur = 0;
6        for (int i = 0; i < n; i++) {
7            char c = s.charAt(i);
8            if (set.contains(c)) {
9                cur++;
10            }
11        }
12        if (k >= s.length()) {
13            return cur;
14
15        }
16        int res = cur;
17        for (int i = n; i < s.length(); i++) {
18            char c = s.charAt(i);
19
20            if (set.contains(c)) {
21                cur++;
22
23            }
24            if (set.contains(s.charAt(i-k))) {
25                cur--;
26
27            }
28            res = Math.max(cur, res);
29        }
30        return res;
31
32
33        
34    }
35}