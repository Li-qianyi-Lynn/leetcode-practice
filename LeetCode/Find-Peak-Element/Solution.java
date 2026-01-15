1class Solution {
2    public int findPeakElement(int[] nums) {
3        int r = nums.length-1;
4        int l = 0;
5
6        while (l < r) {
7            int mid = l + (r-l) / 2;
8            if (nums[mid] <= nums[mid+1]) {
9                l = mid+1;
10                
11            } else {
12                r = mid;
13            }
14        }
15        return r;
16
17        
18    }
19}