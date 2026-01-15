1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int r = nums.length-1;
4        int l = 0;
5
6        while (l <= r) {
7            int mid = l + (r-l) / 2;
8            if (nums[mid] == target) {
9                return mid;
10
11            } else if (nums[mid] < target) {
12                l = mid+1;
13
14            } else {
15                r = mid -1;
16            }
17
18        }
19
20        return l;
21
22        
23    }
24}