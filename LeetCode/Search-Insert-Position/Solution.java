1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int r = nums.length-1;
4        int l = 0;
5        int res = 0;
6
7        while (l <= r) {
8            int mid = l + (r-l) / 2;
9            if (nums[mid] == target) {
10                res = mid;
11                break;
12
13            } else if (nums[mid] < target) {
14                res = mid+1;
15                l = mid+1;
16
17            } else {
18                r = mid -1;
19            }
20
21        }
22
23        return res;
24
25        
26    }
27}