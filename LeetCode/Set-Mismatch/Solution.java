class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int sumTotal = 1;
        int sum1toN = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                res[0] = nums[i];
            } else {
                sum1toN += nums[i];
            }
            sumTotal += i+1;
    
        }
        res[1] = sumTotal - sum1toN;
        return res;
        
    }
}