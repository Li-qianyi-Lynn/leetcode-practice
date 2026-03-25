1class Solution {
2    public boolean isPalindrome(int x) {
3        String s = String.valueOf(x);
4        // int[] arr = new int[s.length()];
5        // for (int i = 0; i < arr.length; i++) {
6        //     arr[i] = s.charAt(i) - '0';
7
8        // }
9        
10        int l = 0;
11        int r = s.length() -1;
12        while (l <= r) {
13            if (s.charAt(l) != s.charAt(r)) {
14                return false;
15
16            } else {
17                l++;
18                r--;
19            }
20        
21
22        }
23        return true;    
24        
25    }
26}