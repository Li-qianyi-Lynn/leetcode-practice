1class Solution {
2    public int search(int[] nums, int target) {
3        int res = 0;
4        int r = nums.length-1;
5        int l = 0;
6
7        while (l <= r) {
8            int mid = l + (r - l)/2;
9            if (nums[mid] == target) {
10                return mid;
11            }
12
13            if (nums[l] <= nums[mid]) { // left in order
14                if (nums[mid] < target || target < nums[l]) {
15                    l = mid + 1;    
16                } else {
17                    r = mid -1;
18                }
19                
20            } else { // right in order
21                if (nums[mid] > target || target > nums[r]) { // check left
22                    r = mid -1;
23
24                } else {
25                    l = mid + 1;
26                }
27
28            }
29
30        }
31        return -1;
32        
33    }
34}