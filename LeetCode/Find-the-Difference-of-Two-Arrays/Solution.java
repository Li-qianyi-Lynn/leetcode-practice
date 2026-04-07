1class Solution {
2    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
3        Set<Integer> set1 = new HashSet<>();
4        for (int num : nums1) {
5            set1.add(num);
6        }
7        Set<Integer> set2 = new HashSet<>();
8        for (int num : nums2) {
9            set2.add(num);
10        }
11        List<List<Integer>> res = new ArrayList<>();
12        Set<Integer> ans0 = new HashSet<>();
13        for (int num : nums1) {
14            if (!set2.contains(num)) {
15                ans0.add(num);
16            }
17        }
18        Set<Integer> ans1 = new HashSet<>();
19        for (int num : nums2) {
20            if (!set1.contains(num)) {
21                ans1.add(num);
22            }
23        }
24        res.add(new ArrayList<>(ans0));
25        res.add(new ArrayList<>(ans1));
26        return res;
27
28
29
30        
31    }
32}