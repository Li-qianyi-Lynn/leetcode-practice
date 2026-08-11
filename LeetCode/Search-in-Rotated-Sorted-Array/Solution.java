1class Solution {
2    public int search(int[] nums, int target) {
3        int n = nums.length;
4        int l = 0;
5        int r = n-1;
6        while (l <= r) {
7            int mid = l + (r-l) / 2;
8            if (nums[mid] == target) {
9                return mid;
10
11            } else if (nums[l] <= nums[mid]) {
12                if (target > nums[mid] || target < nums[l]) {
13                    l = mid +1;
14
15                } else {
16                    r = mid -1;
17                }
18
19            } else {
20                if (target < nums[mid] || target > nums[r]) {
21                    r = mid -1;
22
23                } else {
24                    l = mid +1;
25                }
26
27            }
28
29        }
30        return -1;
31        
32    }
33}
34
35/**
36for loop O（n）
37
38binary search
398
40[7,8,0,1,2]
41     |
42
43nums[l] <= nums[mid]: left in order
44
45target > nums[mid] || target < nums[l]
46l = mid+1
47
48
49
50 */