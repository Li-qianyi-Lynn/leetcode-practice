1class Solution {
2    public boolean canJump(int[] nums) {
3        int maxReach = 0; // index
4        int target = nums.length - 1;
5
6        for (int i = 0; i < nums.length; i++) {
7            if (i > maxReach) {
8                return false;
9            }
10
11            maxReach = Math.max(maxReach,i+ nums[i]);
12            if (maxReach >= target) {
13                return true;
14
15            }
16
17        }
18        return maxReach >= target;
19
20    }
21}