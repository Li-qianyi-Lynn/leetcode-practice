1class Solution {
2    public int minimumPushes(String word) {
3        int[] counts = new int[26];
4        for (char c : word.toCharArray()) {
5            counts[c - 'a']++;
6        }
7        int res = 0;
8        Arrays.sort(counts); // 0 0000.。。12
9        
10        for (int i = 25; i >= 0; i--) {
11            int freq = counts[i];
12            if (freq == 0) {
13                break;
14
15            }
16            int cur = ((25-i) / 8) + 1;
17            res += freq * cur;
18
19        }
20        return res;
21
22
23        
24    }
25}
26/**
27map
28
29char : count
30
31distinct chars n;
32n / 8 + 1
33
34
35
36 */