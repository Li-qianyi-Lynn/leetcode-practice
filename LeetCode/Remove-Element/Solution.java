1class Solution {
2    public int removeElement(int[] nums, int val) {
3        int slow = 0;
4        for (int fast = 0; fast < nums.length; fast++) {
5            if (nums[fast] != val) {
6                nums[slow] = nums[fast]; 
7                slow++;
8
9            }
10
11        }
12        return slow;
13    
14
15        
16    }
17}