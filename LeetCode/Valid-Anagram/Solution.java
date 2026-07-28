1class Solution {
2    public boolean isAnagram(String s, String t) {
3        // pruning 
4        if (s.length() != t.length()) {
5            return false;
6        }
7        int n = s.length();
8        int[] map = new int[26];
9        for (int i = 0; i < n; i++) {
10            int sc = s.charAt(i) - 'a';
11            int tc = t.charAt(i) - 'a';
12            // count chars in s and t
13            map[sc] ++;
14            map[tc] --;
15        }
16
17        // iterate to check if it has non-0
18        for (int m : map) {
19            if (m != 0) {
20                return false;
21            }
22        }
23        return true;
24    }
25}
26/**
27
28anagram:chars same , count same
29input: two strings 
30output: boolean
31
32int[]-> char:count
33 */