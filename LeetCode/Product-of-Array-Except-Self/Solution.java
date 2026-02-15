1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int[] res = new int[n];
5        //left
6        res[0] = 1;
7
8        for (int i = 1; i< n; i++) {
9            res[i] = res[i-1] * nums[i-1];
10        }
11
12        int right = 1;
13        for (int i = n-1; i >= 0; i--) {
14            res[i] = res[i] * right;
15            right *= nums[i];
16
17        }
18        return res;
19
20        
21    }
22}
23/**
24
25res[i] = product left * product right
26
271
281 1 2 6 
29
3012 
31 */