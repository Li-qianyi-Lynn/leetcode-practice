1class Solution {
2    public int search(int[] nums, int target) {
3        int l = 0;
4        int r = nums.length-1;
5
6        // while (l <= r) {
7
8        //     int mid = l + (r-l) / 2;
9
10        //     if (nums[mid] == target) {
11        //         return mid;
12        //     }
13
14        //     if (nums[l] <= nums[mid] ) { // left side in order
15        //         if (target < nums[l] || target > nums[mid]) {
16        //             l = mid +1;
17        //         } else {
18        //             r = mid -1;
19        //         }
20
21        //     } else { // nums[mid]<=target<= nums[r]
22        //         if (target < nums[mid] || target > nums[r]) {
23        //             r = mid -1;
24
25        //         } else {
26        //             l = mid+1;
27        //         }
28        //     }
29
30        // }
31
32
33        while (l <= r) {
34            int mid = l + (r-l) / 2;
35            if (nums[mid] == target) {
36                return mid;
37            }
38
39            if (nums[l] <= nums[mid] ) { // left side in order
40                if (target < nums[l] || target > nums[mid]) {
41                    l = mid + 1;
42                } else {
43                    r = mid -1;
44                    break;
45                }
46            } else {
47                if (target < nums[mid] || target > nums[r]) {
48                    r = mid - 1;
49                } else {
50                    l = mid + 1;
51                    break;
52                }
53            }
54        }
55
56        while (l <= r) {
57            int mid = l + (r - l) / 2;
58            if (nums[mid] == target) {
59                return mid;
60            }
61
62            if (nums[mid] < target) {
63                l = mid + 1;
64            } else {
65                r = mid - 1;
66            }
67        }
68        return -1;
69    }
70}
71
72/**
73binary search
74mid: base point 
75
76return mind
77
78-left side inorder  nums[l]<=target<=nums[mid]
79    binary search 
80-right side inorder
81
82return -1
83
84
85 */