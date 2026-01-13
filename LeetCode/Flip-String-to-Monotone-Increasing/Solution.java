1class Solution {
2    public int minFlipsMonoIncr(String s) {
3        //edge case
4        if (s.length() == 1) {
5            return 0;
6
7        }
8
9        int cur = 0;
10        int min = 0;
11        for (int i = 0; i < s.length(); i++) {
12            char c = s.charAt(i);
13            if (c == '1') {
14                cur++;
15
16            }
17
18        }
19        min = cur;
20        for (int i = s.length()-1; i >= 0; i--) {
21            char c = s.charAt(i);
22
23            if (c == '1') {
24                cur--;
25            } else {
26                cur++;
27            }
28            min = Math.min(cur,min);
29
30        }
31        return min;
32        
33    }
34}
35
36/**
37step1; base line all zeros 
38cur = nums of 1
39
40step2: update min change based on rules (in reverse order)
41- if s[i] == 0
42cur ++
43- s[i] == 1
44cur --
45
46update min
47
48 */