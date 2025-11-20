class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int arr[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        for (int j = 1; j < 101; j++) {
            arr[j] += arr[j-1];
        }

        for (int m = 0; m < nums.length; m++) {
            // int num = nums[i];
            // if (num != 0) nums[i] = arr[num - 1];
            if (nums[m] != 0) {
                nums[m] = arr[nums[m] - 1];
            }

        }
        return nums;
        
    }
}