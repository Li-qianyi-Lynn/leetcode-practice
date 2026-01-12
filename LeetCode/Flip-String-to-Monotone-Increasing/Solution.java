1class Solution {
2    public int minFlipsMonoIncr(String s) {
3        // edge case
4        if (s.length() == '1') {
5            return 0;
6
7        }
8
9        int cur = 0;
10        int min = Integer.MAX_VALUE;
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
22            if (c == '0') {
23                cur++;
24
25            } else {
26                cur--;
27            }
28            min = Math.min(cur,min);
29        }
30        return min;
31
32        
33    }
34}
35/**
36step1: base line: all 0
37step2: update min based on rules(in reverse older)
38- if s == 0, cur++
39- if s == 1, cur--
40return 
41
42
43 */