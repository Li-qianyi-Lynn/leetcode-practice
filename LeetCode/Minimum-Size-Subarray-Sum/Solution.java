1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int res = Integer.MAX_VALUE;
4        int l = 0;
5        int len = nums.length;
6        int cur = 0; // subarray sum
7        for (int r = 0; r < len; r++) {
8            cur += nums[r];
9            while (cur >= target) {
10                res = Math.min(r-l + 1, res);   
11                cur -= nums[l];
12                l++;
13            }
14        
15            
16        }
17        return res == Integer.MAX_VALUE ? 0 : res;
18        
19    }
20}
21//sliding window
22/**
23[2,3,1,2,4,3]
24 l
25        r. 
26
27
28 */
29