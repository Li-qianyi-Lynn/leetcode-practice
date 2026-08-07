1class Solution {
2    public void reverseString(char[] s) {
3        if (s.length == 1) {
4            return;
5
6        }
7        int l = 0;
8        int r = s.length -1;
9        while (l < r) {
10
11            char temp = s[l];
12            s[l] = s[r];
13            s[r] = temp;
14            l++;
15            r--;
16
17        }
18    
19    }
20}