1class Solution {
2    public boolean isPalindrome(String s) {
3        if (s.length() == 1) {
4            return true;
5        
6        }
7        
8
9        int r = s.length()-1;
10        int l = 0;
11
12        while (l < r) {
13            if (l < r && alphaNum(s.charAt(l)) == false ) {
14                l++;
15                continue;
16                }
17            if (l < r && alphaNum(s.charAt(r)) == false ) {
18                r--;
19                continue;
20                }
21
22            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
23                return false;
24
25            }
26
27            l++;
28            r--;
29
30        }
31        return true;
32       
33        
34    }
35
36    private boolean alphaNum(char c) {
37        if (c >= '0' && c <= '9') { return true;}
38        if (c >= 'A' && c <= 'Z') { return true;}
39        if (c >= 'a' && c <= 'z') { return true;}
40
41        return false;
42
43        
44    }
45}