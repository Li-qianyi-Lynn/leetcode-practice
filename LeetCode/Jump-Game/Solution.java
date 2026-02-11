1class Solution {
2    public boolean canJump(int[] nums) {
3        int maxReach = 0;
4        int target = nums.length - 1;
5
6        for (int i = 0; i < nums.length; i++) {
7            if (i > maxReach) {
8                return false;
9            }
10
11            maxReach = Math.max(maxReach,i+ nums[i]);
12
13        }
14        return maxReach >= nums[target];
15
16    }
17}