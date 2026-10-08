1class Solution {
2    public boolean canJump(int[] nums) {
3        int n = nums.length;
4        int maxDis = 0;
5        for (int i = 0; i < n; i++) {
6            
7            if (i > maxDis) {
8                return false;
9
10            }
11            int curStep = nums[i] + i;
12
13            maxDis = Math.max(curStep,maxDis);
14            if (maxDis >= n-1) {
15                return true;
16            }
17        }
18        return false;
19    }
20}