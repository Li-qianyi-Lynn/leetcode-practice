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
16class Solution {
17    int res = 0;
18    public int pathSum(TreeNode root, int targetSum) {
19        Map<Long, Integer> map = new HashMap<>();
20        map.put(0L, 1);
21        dfs(root, map, 0L, targetSum);
22        return res;  
23    }
24
25    private void dfs(TreeNode node, Map<Long,Integer> map, Long curSum, int targetSum) {
26        // base case
27        if (node == null) {
28            return;
29        }
30
31        //1. add the curSum to the map
32        curSum = node.val + curSum;
33        Long searchT = curSum - targetSum;
34        if (map.containsKey(searchT)) {
35            res += map.get(searchT);
36        }
37
38        map.put(curSum, map.getOrDefault(curSum,0)+1);
39
40        // divide
41        dfs(node.left, map, curSum, targetSum);
42        dfs(node.right, map,curSum, targetSum);
43
44        map.put(curSum, map.getOrDefault(curSum,0)-1);
45
46    }
47}
48/**
49
50map: sum -> paths
51update
52
53t = curSum - targetSum res+1
54
55 */