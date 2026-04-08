1class Solution {
2    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
3        // step1: use sets to store num in nums1 and nums2
4        Set<Integer> set1 = new HashSet<>();
5        Set<Integer> set2 = new HashSet<>();
6        for (int num : nums1) {
7            set1.add(num);
8        }
9
10        for (int num : nums2) {
11            set2.add(num);
12        }
13
14        // step2: do the comperations, and use sets to store the ans
15        Set<Integer> ans0 = new HashSet<>();
16        for (int num : nums1) {
17            if (!set2.contains(num)) {
18                ans0.add(num);
19            }
20        }
21
22        Set<Integer> ans1 = new HashSet<>();
23        for (int num : nums2) {
24            if (!set1.contains(num)) {
25                ans1.add(num);
26            }
27        }
28        // step3: use sets to build lists/res
29        List<List<Integer>> res = new ArrayList<>();
30        List<Integer> r1 = new ArrayList<>(ans0);
31        List<Integer> r2 = new ArrayList<>(ans1);
32        res.add(r1);
33        res.add(r2);
34        return res;
35        
36    }
37}
38/**
39input: int[] nums1 nums2
40output:  a list of size 2
41 answer[0]:  distinct integers in nums1 without duplicates
42 ans[1]: distinct integers in nums2 without duplicates
43
44
45
46 */