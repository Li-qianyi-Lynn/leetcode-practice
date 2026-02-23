1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int res = Integer.MAX_VALUE;
4        int curSum = 0;
5        int slow = 0;
6        int fast;
7        for (fast =0; fast < nums.length; fast++) {
8            if (nums[fast]== target) {
9                return 1;
10
11            }
12            curSum += nums[fast];
13
14            while (curSum >= target) {
15                res = Math.min(res, fast-slow+1);
16                curSum -= nums[slow];
17                slow++;
18            }
19        }
20        return res == Integer.MAX_VALUE ? 0 : res;
21        
22    }
23}