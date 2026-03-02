1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length() != t.length()) {
4            return false;
5
6        }
7        int[] sarr = new int[26];
8        int[] tarr = new int[26];
9
10
11        for (int i = 0; i < s.length(); i++) {
12            int idx1 = s.charAt(i) - 'a';
13            int idx2 = t.charAt(i) - 'a';
14            sarr[idx1]++;
15            tarr[idx2]++;
16        }
17
18        return Arrays.equals(sarr,tarr);
19
20
21        
22    }
23}