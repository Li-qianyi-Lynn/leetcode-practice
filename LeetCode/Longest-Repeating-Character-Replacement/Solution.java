1class Solution {
2    public int characterReplacement(String s, int k) {
3        //edge case: len==1 return1
4        if (s.length() ==1 ) {
5            return 1;
6
7        }
8        int len = s.length();
9        int[] map = new int[26];// char -> freq
10        int max = 0;// 在当前区间出现次数最多的
11        int res = 0;//longest
12
13        int l = 0;
14        for (int r =0; r <len; r++) {
15            char c = s.charAt(r);
16            map[c - 'A']++;
17            max = Math.max(max, map[c-'A']);
18            // illegal
19            while (r-l + 1 - max > k) { //todo
20                map[s.charAt(l)- 'A']--;
21                l++;
22            }
23            res = Math.max(res, r-l+1);
24        }
25        return res;
26
27
28
29    }
30}
31/**
32input:  String s, String k
33output: int:  the length of the longest substring: same letter 
34
35sliding window
36 ABACAAAA
37 l
38   r
39
40legal window: 
41max
42window len - num of As vs k
43
44r-l+1
45 */