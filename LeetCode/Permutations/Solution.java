1public class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> perm = new ArrayList<>();
5        backtrack(res, perm, nums, new boolean[nums.length]); // all false, which means not used
6        return res;
7    }
8
9    public void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] pick) {
10        // when to end: perm's size == length of nums
11        if (perm.size() == nums.length) {
12            res.add(new ArrayList<>(perm));
13            return;
14        }
15
16
17        for (int i = 0; i < nums.length; i++) {
18            if (!pick[i]) { // is this num is not used:
19                perm.add(nums[i]); // 1. add it to perm
20                pick[i] = true; //2.  marked as used
21                backtrack(res, perm, nums, pick); // 3. backtrack: choose next num
22
23                // key point : remove and recover
24                perm.remove(perm.size() - 1);
25                pick[i] = false;
26            }
27        }
28    }
29}