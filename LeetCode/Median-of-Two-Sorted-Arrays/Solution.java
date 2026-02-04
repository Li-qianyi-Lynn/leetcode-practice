1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int m = nums1.length;
4        int n = nums2.length;
5        if (n < m) {
6            return findMedianSortedArrays(nums2, nums1);
7        }
8
9        // break point
10        int left = 0;
11        int right = m;
12        int totalLeft = (m+ n+1)/2;
13
14        while (left <= right) {
15            int i = left + (right - left)/2;
16            int j = totalLeft - i;
17
18            if (i > 0 && nums1[i-1] > nums2[j]) {
19                right = i -1;
20            } else if (i < m && nums1[i] < nums2[j-1] ) {
21                left = i+1;
22            } else {
23                // 找到分割点了。要找最大值
24                //left max
25                int leftMax = Integer.MIN_VALUE;
26                if (i == 0) {
27                    leftMax = nums2[j-1];
28                } else if (j == 0) {
29                    leftMax = nums1[i-1];
30                } else {
31                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
32                }
33                
34                if ((m+ n) % 2 == 1) {
35                    return leftMax;  
36                }
37
38                int rightMin = Integer.MAX_VALUE;
39                if (i == m) {
40                    rightMin = nums2[j];
41
42                } else if (j == n) {
43                    rightMin = nums1[i];
44
45                } else {
46                    rightMin = Math.min(nums1[i], nums2[j]);
47                }
48                
49                return (rightMin + leftMax) / 2.0;
50               
51            }
52
53        }
54        return 0.0;   
55    }
56}
57
58/**
59[1 | 3].  [2]|
60在两个数组里切分，i，j使得
61if j < n && num1[i-1] <= nums2[j]
62
63or i < m && nums2[j-1] < nums1[i]
64
65【1 2 ｜ 3】
66
67找到切分点之后，如果m+n 是奇数，中位数就是切分后左边的最大值；偶数，是左边最大值+ 右边最小值取平均数
68
691. 找切分点： j = totalleft - i >= 0 所以我们会希望i 在短数组里取，binary search 来做
70left = 0;
71right = m;
72i = left + (right - left)/2
73j = （m+ n +1）/ 2 - i
74num1[i-1] > nums2[j]
75right = i -1;
76
77nums1[i] <  nums2[j-1] 
78left = i+1
79
80
812. 找左右边最大值
82
83
84 */