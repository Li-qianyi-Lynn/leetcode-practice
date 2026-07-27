1class Solution {
2    public boolean isPalindrome(String s) {
3        // edge case: 
4        if (s.length() <= 1) {
5            return true;
6        }
7
8        String spre = s.toLowerCase();
9
10        // logic two pointer
11        int l = 0;
12        int r = spre.length() -1;
13        while (l < r) {
14            // char cl = spre.charAt(l);
15            // char cr = spre.charAt(r);
16            //preprocess: space/ , . skip
17            while (l < r && !Character.isLetterOrDigit(spre.charAt(l))) { // todo 
18                l++;
19            }
20
21            while (l < r && !Character.isLetterOrDigit(spre.charAt(r))) { // todo 
22                r--;
23            }
24        
25            if (spre.charAt(r)!= spre.charAt(l)) {
26                return false;
27            }
28            l++;
29            r--;
30
31        }
32        return true; 
33    }
34}
35/**
36
37palindrome:  lowercase , remove all non-alnu chars, the same forward and backward order
38input: String s
39output: boolean
40
41amanaplanacanalpanama
42|
43                    |
44
451. pre process split
462. two pointer
47
48 */