     public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        StringBuilder sb = new StringBuilder();
        helper(root, sb, result);
        return result;
    }
    
    
    private void helper(TreeNode root, StringBuilder sb, List<String> result) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) { // leaf node
            result.add(sb.toString());
            return;
        }
        
        // if we are here root has a least 1 child node
        sb.append("->");
        String save = sb.toString();
        helper(root.left, sb, result);
        helper(root.right, new StringBuilder(save), result);
        
    }