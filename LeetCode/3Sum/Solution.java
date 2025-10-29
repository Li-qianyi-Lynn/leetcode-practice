class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // use two pointers (l & r) 
        /**
        if nums[l] + nums[r] < target
        l ++;
        if res > target
        r --;
        else return their index;

        [2,7,11,15]
        |   |     
        
         */


        int l = 0;
        int r = numbers.length -1;
        int[] res = new int[2];

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                res[0] = l+1;
                res[1] = r+1;
                return res;

            }
            

        } 
        return res;
        
    }
}