class Solution {
public:
    int goodNodes(TreeNode* root, int mx = -1e9) {
        if (root == nullptr) return 0;
        return (root->val >= mx ? 1 : 0)
            + goodNodes(root->left, max(root->val, mx))
            + goodNodes(root->right, max(root->val, mx));
    }
};