1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10public class Codec {
11
12    // Encodes a tree to a single string.
13    public String serialize(TreeNode root) {
14        
15
16        StringBuilder sb = new StringBuilder();
17        dfsSeri(root,sb);
18        sb.setLength(sb.length()-1);
19        return sb.toString();
20
21        
22    }
23    private void dfsSeri(TreeNode root, StringBuilder sb) {
24        if (root == null) {
25            sb.append("#,");
26            return;
27        }
28
29        sb.append(root.val).append(",");
30        dfsSeri(root.left, sb);
31        dfsSeri(root.right, sb);
32    }
33
34    // Decodes your encoded data to tree.
35    public TreeNode deserialize(String data) {
36        String[] cur = data.split(",");
37        Deque<String> dq = new ArrayDeque<>();
38        for (String s : cur) {
39            dq.offerLast(s);
40        }
41        TreeNode res = dfsDes(dq);
42        return res;
43        
44    }
45
46    private TreeNode dfsDes(Deque<String> dq) {
47        String curS = dq.pollFirst();
48        if ("#".equals(curS)) {
49            return null;
50
51        }
52
53        TreeNode node = new TreeNode(Integer.parseInt(curS));
54        node.left = dfsDes(dq);
55        node.right = dfsDes(dq);
56        return node;
57
58    }
59}
60
61// Your Codec object will be instantiated and called as such:
62// Codec ser = new Codec();
63// Codec deser = new Codec();
64// TreeNode ans = deser.deserialize(ser.serialize(root));