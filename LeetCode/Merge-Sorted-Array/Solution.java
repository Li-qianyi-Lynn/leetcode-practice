1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        // edge case: m == 1 n ==0
4        if (m == 1 && n== 0) {
5            return;
6        }
7
8        if (m == 0 && n == 1) {
9            nums1[0] = nums2[0];
10            return;
11        }
12        // two pointers
13        int i = m-1;
14        int j = n-1;
15        int k = m+n-1;
16
17        while (i >= 0 && j >= 0) {
18            if (nums1[i] >= nums2[j]) {
19                nums1[k] = nums1[i];
20                i--;
21            } else {
22                nums1[k] = nums2[j];
23                j--;
24
25            }
26            k--;
27        }
28
29        while (j >= 0) {
30            nums1[k] = nums2[j];
31            j--;
32            k--;
33           
34        }
35
36        
37    }
38}
39/**
40
41
42
43
44 */