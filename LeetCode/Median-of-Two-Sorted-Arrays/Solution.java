1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        // 确保 nums1 是短数组，这样二分查找更快，且能保证 j 的计算结果不为负数
4        if (nums1.length > nums2.length) {
5            return findMedianSortedArrays(nums2, nums1);
6        }
7
8        int m = nums1.length;
9        int n = nums2.length;
10        
11        // left 和 right 是在 nums1 里的分割位置（0 到 m）
12        int left = 0, right = m;
13        // leftTotal 是合并后左半部分的元素个数,左边比右边多一个或者相等
14        int leftTotal = (m + n + 1) / 2; //3
15
16        while (left <= right) {
17            // 计数器：i 是 nums1 的分割点，j 是 nums2 的分割点，从中间割起
18            int i = left + (right - left) / 2;
19            int j = leftTotal - i;
20
21            // 检查分割是否完美，比较小的数
22            // nums1[i-1] 必须 <= nums2[j]
23            // nums2[j-1] 必须 <= nums1[i]
24            // 2 ｜ 3    1 2 ｜ 5
25            
26            // 如果 nums1[i-1] 太大了，说明 i 需要左移
27            if (i > 0 && nums1[i - 1] > nums2[j]) {
28                right = i - 1;
29            } 
30            // 如果 nums2[j-1] 太大了，说明 i 需要右移
31            else if (i < m && nums2[j - 1] > nums1[i]) {
32                left = i + 1;
33            } 
34            // 找到了完美的分割点！
35            else {
36                // 计算左侧最大值
37                int maxLeft = 0;
38                if (i == 0) maxLeft = nums2[j - 1]; // nums1 左边没数，nums1  |[3,4] [1,2]|
39                else if (j == 0) maxLeft = nums1[i - 1]; // nums2 左边没数
40                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
41
42                // 如果总长度是奇数，中位数就是左侧最大值
43                if ((m + n) % 2 == 1) {
44                    return maxLeft;
45                }
46
47                // 如果是偶数，还需要计算右侧最小值
48                int minRight = 0;
49                if (i == m) minRight = nums2[j]; // nums1 右边没数
50                else if (j == n) minRight = nums1[i]; // nums2 右边没数
51                else minRight = Math.min(nums1[i], nums2[j]);
52
53                return (maxLeft + minRight) / 2.0;
54            }
55        }
56        return 0.0;
57    }
58}