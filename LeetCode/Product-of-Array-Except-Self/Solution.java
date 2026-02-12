1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int[] res = new int[nums.length];
4        res[0] = 1;
5        int n = nums.length;
6        // left side
7        for (int i = 1; i < n; i++) {
8            res[i] = nums[i-1] * res[i-1];
9        } 
10
11        // right side
12        int right = 1;
13        for (int i = n-1; i >= 0; i--) {
14            res[i] = res[i] * right;
15            right *= nums[i]; // prepare for next round
16
17        }
18        return res;
19    }
20}
21
22/**
23
24res[i] = product in left * products in right
25
26
27
28
29 */