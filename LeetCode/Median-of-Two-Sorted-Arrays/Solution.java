1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        // 保证 nums1 为较短数组，保证二分的时间复杂度为 O(log(min(m, n)))
4        if (nums1.length > nums2.length) {
5            return findMedianSortedArrays(nums2, nums1);
6        }
7
8        int m = nums1.length;
9        int n = nums2.length;
10        int totalLeft = (m + n + 1) / 2;
11
12        int left = 0;
13        int right = m;
14
15        while (left <= right) {
16            int i = left + (right - left) / 2; // nums1 的分割点
17            int j = totalLeft - i;             // nums2 的分割点
18
19            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
20            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
21            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
22            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
23
24            if (left1 <= right2 && left2 <= right1) {
25                if ((m + n) % 2 == 1) {
26                    return Math.max(left1, left2);
27                } else {
28                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
29                }
30            } else if (left1 > right2) {
31                right = i - 1;
32            } else {
33                left = i + 1;
34            }
35        }
36
37        return 0.0;
38    }
39}
40
41/**
42
43input：nums1[] nums2[] sorted ascend
44output: double
45
46binary search
47|1  3  4.     2. | 5
48  i-1. i      j-1.  j
49left: 123
50right: 56
51
521. break point 
53left = 0;
54right = m;
55
56nums1: i 取了 i 个数字
57nums2: j 
58nums1[i-1] <= nums2[j]
59nums2[j-1] <= nums1[i]
60
61以nums1 为定位
62
63left = 0;
64right = m;
65
66i = left + (right - left)/2
67j = totalLeft - i；
68
69while (left <= right) 
70condition1 nums1[i-1] > nums2[j] i-1>= 0 ;right = i-1;
71condition2 nums2[j-1] > nums1[i] j-1 >= 0; left = i+1;
72
73
742. maxLeft. minRight -> median
75edge cases
76
77 */