class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int position = 0;
        return kthSmallestRec(root, k, position)->val;
    }
    TreeNode* kthSmallestRec(TreeNode* node, int k, int& position){
        if(node == NULL){ return node;}
        
        TreeNode* left = kthSmallestRec(node->left, k, position);
        if(left != NULL){
            return left;
        }
        
        position++;
        if(position == k){
            return node;
        }
        
        return kthSmallestRec(node->right, k, position);
    }
};