1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        //edge case
4        if (n == 0) {
5            return;
6
7        }
8
9        if (m == 0 && n == 1) {
10            nums1[0] = nums2[0];
11            return;
12
13        }
14
15        int i = m-1;
16        int j = n-1;
17        int k = m+n-1;
18
19        while (i >= 0 && j >= 0) {
20            if (nums1[i] >= nums2[j]) {
21                nums1[k] = nums1[i];
22                i--;
23            } else {
24                nums1[k] = nums2[j];
25                j--;
26            }
27            k--;
28        }
29
30        while (j >= 0) {
31            nums1[k] = nums2[j];
32            j--;
33            k--;
34
35        }
36
37
38        
39    }
40}
41/**
42
43nums1 = [1,2,2,3,5,6]
44         i
45         k
46m = 3, 
47
48nums2 = [2,5,6], n = 3
49      j
50
51
52 */