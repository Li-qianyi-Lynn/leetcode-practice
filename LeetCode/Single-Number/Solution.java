1class Solution {
2    public int singleNumber(int[] nums) {
3        int a = 0;
4        for (int num : nums) {
5            a ^= num;
6
7        }
8        return a;
9        
10    }
11}
12
13/**
14
15tc:O(n)
16sc:O(1)
17
18 */