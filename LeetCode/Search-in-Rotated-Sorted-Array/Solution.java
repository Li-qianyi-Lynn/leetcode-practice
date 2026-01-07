1class Solution {
2    public int search(int[] nums, int target) {
3        int l = 0;
4        int r = nums.length - 1;
5
6        while(l <= r) {
7
8            int mid = (l + r) / 2;
9
10            if (nums[mid] == target) {
11                return mid;
12            }
13
14            if (nums[l] <= nums[mid]) {
15                if (target > nums[mid] || target < nums[l]) {
16                    l = mid + 1;
17                } else {
18                    r = mid - 1;
19                }
20            } else {
21                if (target < nums[mid] || target > nums [r]) {
22                    r = mid - 1;
23                } else {
24                    l = mid + 1;
25                }
26            }
27
28        }
29
30        return -1;
31    }
32}