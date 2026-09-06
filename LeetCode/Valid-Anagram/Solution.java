1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length() != t.length()) {
4            return false;
5
6        }
7        int[] arrS = new int[26];
8        int[] arrT = new int[26];      
9
10        for (char c : s.toCharArray()) {
11            arrS[c-'a']++;
12        } 
13        for (char c : t.toCharArray()) {
14            arrT[c-'a']++;
15        } 
16
17        for (int i = 0; i< 26; i++) {
18            if (arrS[i] != arrT[i]) {
19                return false;
20
21            }
22
23        }
24        return true;
25        
26        
27    }
28}