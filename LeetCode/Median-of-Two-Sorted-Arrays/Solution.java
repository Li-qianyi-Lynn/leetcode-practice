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
18    
19            if (i >= 1 && nums1[i-1] > nums2[j]) {
20                r = i-1;
21
22            } else if ( i < m && nums2[j-1] > nums1[i]) {
23                l = i+1;
24            } else { // find the break point
25                // leftmax rightmin
26                double leftMax = Integer.MIN_VALUE;
27                if (i == 0) {
28                    leftMax = nums2[j-1];
29                } else if (j == 0) {
30                    leftMax = nums1[i-1];
31
32                } else {
33                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
34                }
35                if ((m+n) % 2 == 1) {
36                    return leftMax;
37                }
38
39                double rightMin = Integer.MAX_VALUE;
40                if (i == m) {
41                    rightMin = nums2[j];
42                } else if (j == n) {
43                    rightMin = nums1[i];
44                } else {
45                    rightMin = Math.min(nums1[i], nums2[j]);
46                }
47
48                return (rightMin + leftMax) / 2.0;
49            }
50
51        }
52        return 0.0;    
53    }
54}
55
56/**
57
58input：nums1[] nums2[] sorted ascend
59output: double
60
61binary search
62|1  3  4.     2. | 5
63  i-1. i      j-1.  j
64left: 123
65right: 56
66
671. break point 
68left = 0;
69right = m;
70
71nums1: i 取了 i 个数字
72nums2: j 
73nums1[i-1] <= nums2[j]
74nums2[j-1] <= nums1[i]
75
76以nums1 为定位
77
78left = 0;
79right = m;
80
81i = left + (right - left)/2
82j = totalLeft - i；
83
84while (left <= right) 
85condition1 nums1[i-1] > nums2[j] i-1>= 0 ;right = i-1;
86condition2 nums2[j-1] > nums1[i] j-1 >= 0; left = i+1;
87
88
892. maxLeft. minRight -> median
90edge cases
91
92 */