class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i]-1;
            // swap until the nums[i] is at index nums[i]-1
            while(idx != nums[i]){
                swap(nums, idx, i);
                idx = nums[i] - 1;
                // if we are going to swap same number: break
                if(nums[idx] == nums[i]){
                    break;
                }
            }
        }
        // In this point, the array looks like this: [1,2,3,4,3,2,7,8]
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]-1){
                res.add(i+1);
            }
        }
        
        return res;
    }
    
    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}