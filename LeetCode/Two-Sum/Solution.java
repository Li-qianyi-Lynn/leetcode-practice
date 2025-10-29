class Solution {
    public int[] twoSum(int[] nums, int target) {
        // use map to store index and nums[i] k:nums[i] v: index 
        /**
        when we get a num, check if the target-num is in map:
        - if exist, return their index;
        - if no, restore this num into map
         */

         Map<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (map.containsKey(tar)) {
                return new int[]{i, map.get(tar)};

            }
            map.put(nums[i], i);   

        }
        return new int[]{};
        
    }
}