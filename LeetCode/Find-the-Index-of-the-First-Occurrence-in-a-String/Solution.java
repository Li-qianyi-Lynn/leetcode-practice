1class Solution {
2    public int strStr(String haystack, String needle) {
3        int len1 = haystack.length();
4        int len2 = needle.length();
5        if (len1 == 0 || len2 == 0) {
6            return -1;
7
8        }
9        for (int i = 0, j = len2; j <= len1; i++, j++) {
10            if (haystack.substring(i,j).equals(needle)) {
11                return i;
12
13            }
14
15        }
16        return -1;
17
18        
19    }
20}