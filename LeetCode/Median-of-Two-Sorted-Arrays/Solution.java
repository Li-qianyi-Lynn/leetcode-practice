1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int m = nums2.length;
5        // 这里的 left 和 right 是指合并后的第几个数（从1开始算）
6        int left = (n + m + 1) / 2;
7        int right = (n + m + 2) / 2;
8        
9        // 将偶数和奇数的情况合并：如果是奇数，left == right；如果是偶数，求平均值
10        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + 
11                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
12    }
13
14    /**
15     * 辅助函数：在两个数组的指定区间内，寻找合并后的第 k 小的元素
16     */
17    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
18        int len1 = end1 - start1 + 1;
19        int len2 = end2 - start2 + 1;
20
21        // 始终让 len1 <= len2，确保如果有一个数组空了，一定是 nums1
22        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
23        
24        // 边界情况
25        if (len1 == 0) return nums2[start2 + k - 1]; // nums1 空了，直接在 nums2 找
26        if (k == 1) return Math.min(nums1[start1], nums2[start2]); // 找最小的，看两个数组头谁小
27
28        // 技巧 3: 核心逻辑 - 每次排除 k/2 个元素，防止数组长度不够，所以取 min(长度, k/2)
29        int i = start1 + Math.min(len1, k / 2) - 1;
30        int j = start2 + Math.min(len2, k / 2) - 1;
31
32        if (nums1[i] > nums2[j]) {
33            // 说明 nums2 的前半部分（到 j 为止）一定不包含第 k 小，排除掉
34            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
35        } else {
36            // 说明 nums1 的前半部分一定不包含第 k 小，排除掉
37            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
38        }
39    }
40}