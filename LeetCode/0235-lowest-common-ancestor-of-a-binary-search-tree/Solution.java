/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //dfs
        //base case
        if (root == null) {
            return null; 
        }

        if (p  == root || q == root) {
            return root;
        } 

        // check left or right child trees?
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);

        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);

        } else {
            return root;
        }


        
    }
}

/**
bst: left child tree node's value < root.val < right child

input: root, treenodes p q
output: treenode

dfs

 */