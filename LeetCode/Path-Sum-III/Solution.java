1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16
17
18class Solution {
19    public int pathSum(TreeNode root, int targetSum) {
20        // key: 前缀和, value: 该前缀和出现的次数
21        Map<Long, Integer> prefixSumCount = new HashMap<>();
22        
23        // Base case: 初始化前缀和为 0 的次数为 1
24        // 意义在于：如果从根节点到当前节点的总和刚好等于 targetSum，
25        // 那么 currSum - targetSum = 0，此时我们需要能查到 0 这个前缀和。
26        prefixSumCount.put(0L, 1);
27        
28        // 开始深度优先搜索
29        return dfs(root, 0L, targetSum, prefixSumCount);
30    }
31
32    private int dfs(TreeNode node, Long currSum, int targetSum, Map<Long, Integer> prefixSumCount) {
33        // 递归终止条件
34        if (node == null) {
35            return 0;
36        }
37
38        // 1. 更新当前节点的前缀和
39        currSum += node.val;
40
41        // 2. 核心逻辑：查询哈希表中是否存在 currSum - targetSum
42        // 如果存在，说明找到了一条或多条满足条件的路径
43        int res = prefixSumCount.getOrDefault(currSum - targetSum, 0);
44
45        // 3. 将当前的前缀和加入哈希表，准备遍历子节点
46        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
47
48        // 4. 继续递归遍历左子树和右子树，并累加结果
49        res += dfs(node.left, currSum, targetSum, prefixSumCount);
50        res += dfs(node.right, currSum, targetSum, prefixSumCount);
51
52        // 5. 回溯阶段（恢复状态）
53        // 当前节点的子树遍历完了，返回上一层之前，必须把当前前缀和的次数减 1
54        // 防止左子树的前缀和被右子树“跨越分支”错误使用
55        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
56
57        return res;
58    }
59}