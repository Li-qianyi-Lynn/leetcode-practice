1class Solution {
2    public boolean isPalindrome(String s) {
3        if (s.length() == 1) {
4            return true;
5
6        }
7
8        int l = 0;
9        int r = s.length()-1;
10
11        while (l < r) {
12            if (l < r && alpha(s.charAt(l)) == false) {
13                l++;
14                continue;
15            } else if (l < r && alpha(s.charAt(r)) == false) {
16                r--;
17                continue;
18
19            }
20
21            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
22                return false;
23
24            }
25            l++;
26            r--;
27          
28        }
29        return true;
30        
31    }
32    private boolean alpha(char c) {
33        if (c >= '0' && c <= '9') {
34            return true;
35
36        }
37        if (c >= 'a' && c <= 'z') {
38            return true;
39
40        }
41        if (c >= 'A' && c <= 'Z') {
42            return true;
43
44        }
45        return false;
46
47    }
48}