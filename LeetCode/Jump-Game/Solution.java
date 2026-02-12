1class Solution {
2    public boolean canJump(int[] nums) {
3        int max = 0;
4        int n = nums.length;
5        for (int i = 0; i < n; i++) {
6            if (i > max) {
7                break;
8            }
9            max = Math.max(max, i+ nums[i]);
10            if (max >= n-1) {
11                return true;
12            }
13        }
14        return false;
15    }
16}
17/**
18maxi + nums[i]
19
20 */