1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4// [[],[2],[2,2],[2,2,2]]
5// start: 2
6// cur: [2,2]
7// res: [[],[2], [2,2],[2,2,2]]
8
9class Solution {
10    public List<List<Integer>> subsetsWithDup(int[] nums) {
11        List<List<Integer>> result = new ArrayList<>();
12        // 1. 排序，让相同元素相邻
13        Arrays.sort(nums);
14        backtrack(nums, 0, new ArrayList<>(), result);
15        return result;
16    }
17
18    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
19        // 收集当前子集
20        result.add(new ArrayList<>(current));
21
22        for (int i = start; i < nums.length; i++) { //0
23            // 同一树层遇到重复元素，跳过以避免重复子集 【2，2, 2】 
24            if (i > start && nums[i] == nums[i - 1]) {
25                continue;
26            }
27            current.add(nums[i]);
28            // 递归进入下一层
29            backtrack(nums, i + 1, current, result);
30            // 回溯撤销选择
31            current.remove(current.size() - 1);
32        }
33    }
34}