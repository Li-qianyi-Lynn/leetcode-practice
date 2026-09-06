1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        HashSet<Integer> set = new HashSet<>();
4        HashSet<Integer> resSet = new HashSet<>();
5        if (nums2.length < nums1.length) {
6            int[] temp = nums1;
7            nums1 = nums2;
8            nums2 = temp;
9
10        }
11        for (int i = 0; i < nums1.length; i++) {
12            set.add(nums1[i]);
13
14        }
15        for (int i = 0; i < nums2.length; i++) {
16            if (set.contains(nums2[i])) {
17                resSet.add(nums2[i]);
18
19            }
20
21        }
22        int[] res = new int[resSet.size()];
23        int idx = 0;
24        for (int num : resSet) {
25
26            res[idx++] = num;
27
28        }
29        return res;
30        
31    }
32}