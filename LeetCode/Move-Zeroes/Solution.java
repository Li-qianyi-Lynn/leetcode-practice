class Solution {
    public void moveZeroes(int[] nums) {
        int fast, slow;
        for (fast = 0, slow = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;

            }

        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;

        }
        
    }
}