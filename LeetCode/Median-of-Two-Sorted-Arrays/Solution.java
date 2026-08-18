1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int m = nums1.length;
4        int n = nums2.length;
5
6        if (m > n) {
7            return findMedianSortedArrays(nums2, nums1);
8        }
9
10        int l = 0;
11        int r = m;
12        int totalLeft = (m+n+1)/2;
13
14        while (l <= r) {
15            int i = l + (r - l)/2;
16            int j = totalLeft - i;
17
18            int left1;
19            int right1;
20            int left2;
21            int right2;
22            if (i == 0) {
23                left1 = Integer.MIN_VALUE;
24
25            } else {
26                left1 = nums1[i-1];
27            }
28            if (i == m) {
29                right1 = Integer.MAX_VALUE;
30
31            } else {
32                right1 = nums1[i];
33            }
34
35            if (j == 0) {
36                left2 = Integer.MIN_VALUE;
37
38            } else {
39                left2 = nums2[j-1];
40            }
41
42            if (j == n) {
43                right2 = Integer.MAX_VALUE;
44            } else {
45                right2 = nums2[j];
46            }
47           
48
49
50            if (left1 > right2) {
51                r = i-1;
52
53            } else if ( left2 > right1) {
54                l = i+1;
55            } else { // find the break point
56                // leftmax rightmin
57               
58                double leftMax = Integer.MIN_VALUE;
59                leftMax = Math.max(left1,left2);
60               
61                if ((m+n) % 2 == 1) {
62                    return leftMax;
63                }
64
65                double rightMin = Integer.MAX_VALUE;
66               
67                rightMin = Math.min(right1, right2);
68            
69
70                return (rightMin + leftMax) / 2.0;
71            }
72
73        }
74        return 0.0;    
75    }
76}
77
78/**
79
80input：nums1[] nums2[] sorted ascend
81output: double
82
83binary search
84|1  3  4.     2. | 5
85  i-1. i      j-1.  j
86left: 123
87right: 56
88
891. break point 
90left = 0;
91right = m;
92
93nums1: i 取了 i 个数字
94nums2: j 
95nums1[i-1] <= nums2[j]
96nums2[j-1] <= nums1[i]
97
98以nums1 为定位
99
100left = 0;
101right = m;
102
103i = left + (right - left)/2
104j = totalLeft - i；
105
106while (left <= right) 
107condition1 nums1[i-1] > nums2[j] i-1>= 0 ;right = i-1;
108condition2 nums2[j-1] > nums1[i] j-1 >= 0; left = i+1;
109
110
1112. maxLeft. minRight -> median
112edge cases
113
114 */