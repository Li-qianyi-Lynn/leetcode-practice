1public class Solution {
2    List<List<Integer>> res;
3    public List<List<Integer>> permute(int[] nums) {
4        res = new ArrayList<>();
5        backtrack(new ArrayList<>(), nums, new boolean[nums.length]); // all false
6        return res;
7    }
8
9    public void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
10        if (perm.size() == nums.length) {
11            res.add(new ArrayList<>(perm));
12            return;
13        }
14        for (int i = 0; i < nums.length; i++) {
15            if (!pick[i]) {
16                perm.add(nums[i]);
17                pick[i] = true;
18                backtrack(perm, nums, pick);
19                perm.remove(perm.size() - 1);
20                pick[i] = false;
21            }
22        }
23    }
24}