1class Solution {
2    public int findMin(int[] nums) {
3        int r = nums.length-1;
4        int l = 0;
5        while (l < r) {
6            int mid = l + (r-l) / 2;
7            if (nums[mid] < nums[r]) {
8                r = mid;
9
10            } else {
11                l = mid+1;
12            }
13        }
14        return nums[l];   
15    }
16}