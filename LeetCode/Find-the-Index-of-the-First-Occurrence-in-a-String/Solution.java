1class Solution {
2    public int strStr(String haystack, String needle) {
3        int len1 = haystack.length();
4        int len2 = needle.length();
5
6     
7        for(int i = 0, j = len2; j <= len1; i++,j++) {
8            if (haystack.substring(i,j).equals(needle)) {
9                return i;
10            }
11
12        }
13        return -1;
14
15        
16    }
17}