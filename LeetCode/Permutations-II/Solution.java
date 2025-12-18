1class Solution {
2    List<List<Integer>> res;
3    public List<List<Integer>> permuteUnique(int[] nums) {
4        res = new ArrayList<>();
5        Arrays.sort(nums);
6        backtrack(new ArrayList<>(), nums, new boolean[nums.length]); // all false
7        return res;
8    }
9
10    public void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
11        if (perm.size() == nums.length) {
12            res.add(new ArrayList<>(perm));
13            return;
14        }
15        for (int i = 0; i < nums.length; i++) {
16            if (i > 0 && nums[i] == nums[i-1] && !pick[i-1]) continue; // delete duplicated
17
18            if (!pick[i]) {
19                perm.add(nums[i]);
20                pick[i] = true;
21                backtrack(perm, nums, pick);
22                perm.remove(perm.size() - 1);
23                pick[i] = false;
24            }
25        }
26    }
27}