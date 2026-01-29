class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        TreeNode* curr = root;
        int prev = 1e9, ans = 1e9;
        while (curr != nullptr) {
            if (curr->left == nullptr) {
                ans = min(ans, abs(curr->val - prev));
                prev = curr->val;
                curr = curr->right;
            }
            else {
                TreeNode * temp = curr->left;
                while (temp->right != nullptr && temp->right != curr) {
                    temp = temp->right;
                } 
                if (temp->right == nullptr) {
                    temp->right = curr;
                    curr = curr->left;
                }
                else {
                    temp->right = nullptr;
                    ans = min(ans, abs(curr->val - prev));
                    prev = curr->val;
                    curr = curr->right;
                }
            }
        }
        return ans;
    }
};