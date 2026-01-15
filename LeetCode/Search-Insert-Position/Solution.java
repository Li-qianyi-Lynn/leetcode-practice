1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int r = nums.length;
4        int l = 0;
5
6        while (l < r) {
7            int mid = l + (r-l) / 2;
8            
9            if (nums[mid] >= target) {
10                
11                r = mid;
12
13            } else {
14                l = mid+1;
15            }
16
17        }
18
19        return l;
20
21        
22    }
23}