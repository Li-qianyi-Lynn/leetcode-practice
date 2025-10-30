class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        /**
        step1: sort, prepare for two pointers O(nlogn)
        step2: iterate nums,use two pointers (l = i+1; r = length-1) to check 
        if nums[i] + nums[l] +nums[r] == 0. O(n)
            - it is possible to have duplicate res, we need to remove duplicates
            - i == i+1 continue;
            - l = l+1 continue;
            - r = r -1 continue;


        step3: add res to results;
        
     
         */

        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int l = i +1;
            int r = len -1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < 0) {
                    l ++;

                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r --;

                } else {
                    results.add(Arrays.asList(nums[i], nums[r],nums[l]));
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;

                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;

                    }

                    // when i found one solution, skip duplicated l!!
                }

            }

        }

        return results;
        
    }
}