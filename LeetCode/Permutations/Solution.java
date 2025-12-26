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
14            // System.out.println(perm);
15            return;
16        }
17
18        for (int i = 0; i < nums.length; i++) {
19            if (used[i] == false) {
20                perm.add(nums[i]);
21                used[i] = true;
22                backtrack(res, perm, nums, used);
23
24                perm.remove(perm.size() -1);
25                used[i] = false;
26            }
27        }
28
29    }
30}
31
32/**
33backtrack:
341. take nums[i] one by one to be one possible result(perm), boolean int[nums.length] = false
352. if the num is used, marked as used (true), and then use backtrack to continue choosing next num
363. end condition: size of perm == length of nums
37
384. recover: remove nums[i] from perm, marked as false for next use
39
40 */