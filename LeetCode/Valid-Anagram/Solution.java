1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length() != t.length()) {
4            return false;
5
6        }
7        int[] count = new int[26];
8
9
10        for (int i = 0; i < s.length(); i++) {
11            int idx1 = s.charAt(i) - 'a';
12            int idx2 = t.charAt(i) - 'a';
13            count[idx1]++;
14            count[idx2]--;
15        }
16
17        for (int i : count) {
18            if (i != 0) {
19                return false;
20            }
21
22        }
23        return true;
24
25
26        
27    }
28}