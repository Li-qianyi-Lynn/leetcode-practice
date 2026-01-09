1class Solution {
2    public int[] plusOne(int[] digits) {
3        int len = digits.length;
4        for (int i = len-1; i >=0; i--) {
5            if (digits[i] != 9) {
6                digits[i] = digits[i]+1;
7                return digits;
8
9            } else {
10                digits[i] = 0; //[1,2,9]
11            }
12
13        }
14        // 每一位都是0 
15        digits = new int[len+1];
16        digits[0] = 1;
17        return digits;
18        
19    }
20}
21
22/**
23如果末尾！= 9， +1
24如果末尾 = 9， digits[i] = 0, 向前进一位
25
26 */