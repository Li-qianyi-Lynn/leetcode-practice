1class Solution {
2    public boolean canJump(int[] nums) {
3        int last = nums.length-1;
4        for (int i = last; i >=0; i--) {
5
6            if (i+ nums[i] >= last) {
7                last = i;
8
9            }
10        }
11        return last == 0;
12        
13    }
14}