1class Solution {
2    public void moveZeroes(int[] nums) {
3        int fast, slow;
4        for (fast = 0, slow = 0; fast < nums.length; fast++) {
5            if (nums[fast] != 0) {
6                nums[slow] = nums[fast];
7                slow++;
8            }
9        }
10        for (int i = slow; i < nums.length; i++) {
11            nums[i] = 0;
12        }      
13    }
14}