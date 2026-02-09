1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        //pruning
4        if (m == 0) {
5            nums1[0] = nums2[0];
6
7        }
8        if (n == 0) {
9            return;
10
11        }
12        int arr1 = m-1;
13        int arr2 = n-1;
14        int valid = m+n-1; 
15        while (arr1>= 0 && arr2 >= 0 ) {
16            if (nums1[arr1] > nums2[arr2]) {
17                nums1[valid] = nums1[arr1];
18                
19                arr1--;
20
21            } else {
22                nums1[valid] = nums2[arr2];
23                arr2--;
24
25            }
26            valid--;
27        }
28        // nums1 已经排好了所以不用换，要换nums2
29        while (arr2 >= 0) {
30            nums1[valid] = nums2[arr2];
31            arr2--;
32            valid--;
33
34        }    
35    }
36}
37
38/**
39nums1 = [1,2, 3, 0, 0 ,0] m
40 
41             m-1      m+n-1
42nums2 = [2,5,6] n
43             n-1
44
45//edge case
46m == 0  nums1 = nums2 ; == 1, return 
47
48
49
50 */