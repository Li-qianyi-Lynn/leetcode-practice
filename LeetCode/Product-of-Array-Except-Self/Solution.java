class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        //left 
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        //right 
        int rightProduct = 1; // 右侧累计乘积
        for (int j = nums.length-1; j >=0; j--) {
            res[j] *= rightProduct;
            rightProduct *= nums[j];
        }

        return res;    
    }
}