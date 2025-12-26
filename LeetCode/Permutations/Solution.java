1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> perm = new ArrayList<>();
5        boolean[] used = new boolean[nums.length];
6        backtrack (res, perm, nums, used);
7        return res;
8    }
9
10    private void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used) {
11        // base case
12        if (perm.size() == nums.length) {
13            res.add(new ArrayList<>(perm));
14            return;
15        }
16
17        for (int i = 0; i < nums.length; i++) {
18            if (used[i] == false) {
19                perm.add(nums[i]);
20                used[i] = true;
21                backtrack(res, perm, nums, used);
22
23                perm.remove(perm.size() -1);
24                used[i] = false;
25            }
26        }
27
28    }
29}
30
31/**
32backtrack:
331. take nums[i] one by one to be one possible result(perm), boolean int[nums.length] = false
342. if the num is used, marked as used (true), and then use backtrack to continue choosing next num
353. end condition: size of perm == length of nums
36
374. recover: remove nums[i] from perm, marked as false for next use
38
39 */