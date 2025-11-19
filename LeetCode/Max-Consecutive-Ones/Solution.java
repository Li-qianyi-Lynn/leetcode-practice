class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 0;
            }

        }
        return max;
        
    }
}