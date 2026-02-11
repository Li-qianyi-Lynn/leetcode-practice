1class Solution {
2    public boolean canJump(int[] nums) {
3        int maxReach = 0;
4        int target = nums.length - 1;
5
6        for (int i = 0; i < nums.length; i++) {
7            // jump to zero
8            if (i > maxReach) {
9                return false;
10            }
11
12            
13            maxReach = Math.max(maxReach, i + nums[i]);
14
15            // pruning: 如果最远距离已经覆盖了最后一个下标，直接返回 true
16            if (maxReach >= target) {
17                return true;
18            }
19        }
20
21        return maxReach >= target;
22    }
23}