1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> subsetsWithDup(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        // 1. 排序，让相同元素相邻
9        Arrays.sort(nums);
10        backtrack(nums, 0, new ArrayList<>(), result);
11        return result;
12    }
13
14    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
15        // 收集当前子集
16        result.add(new ArrayList<>(current));
17
18        for (int i = start; i < nums.length; i++) {
19            // 同一树层遇到重复元素，跳过以避免重复子集
20            if (i > start && nums[i] == nums[i - 1]) {
21                continue;
22            }
23            current.add(nums[i]);
24            // 递归进入下一层
25            backtrack(nums, i + 1, current, result);
26            // 回溯撤销选择
27            current.remove(current.size() - 1);
28        }
29    }
30}