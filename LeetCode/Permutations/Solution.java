1public class Solution {
2    // List<List<Integer>> res;
3    public List<List<Integer>> permute(int[] nums) {
4        List<List<Integer>> res = new ArrayList<>();
5        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]); // all false, which means not used
6        return res;
7    }
8
9    public void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] pick) {
10        // when to end: perm's size == length of nums
11        if (perm.size() == nums.length) {
12            res.add(new ArrayList<>(perm));
13            return;
14        }
15        for (int i = 0; i < nums.length; i++) {
16            if (!pick[i]) {
17                perm.add(nums[i]);
18                pick[i] = true;
19                backtrack(res, perm, nums, pick);
20                perm.remove(perm.size() - 1);
21                pick[i] = false;
22            }
23        }
24    }
25}