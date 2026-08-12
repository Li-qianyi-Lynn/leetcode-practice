1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        if (n == 0) {
4            return;
5        }
6   
7
8        int p1 = m-1;
9        int p2 = n-1;
10        int valid = m+n -1;
11
12        while (p1 >= 0 && p2 >= 0) {
13            if (nums1[p1] < nums2[p2]) {
14                nums1[valid] = nums2[p2];
15                p2--;
16
17            } else {
18                nums1[valid] = nums1[p1];
19                p1--;
20            }
21            valid--;
22
23        }
24        while (p2 >= 0 ) {
25            nums1[valid] = nums2[p2];
26            valid --;
27            p2--;
28
29        }
30        
31    }
32}
33/**
34
35three pointers
36
37nums1:[1,2,3,0,0,0]
38           |
39                  |
40                valid
41
42nums2:[2,5,6]
43           |
44
45nums1 left, return directly
46nums2 left, add nums2[i] to nums1[]
47
48 */