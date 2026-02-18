1class Solution {
2    // use trie
3    class TrieNode {
4        TrieNode[] children = new TrieNode[26];
5        String target = null; 
6    }
7
8    public List<String> findWords(char[][] board, String[] words) {
9        List<String> res = new ArrayList<>();
10        TrieNode root = buildTrie(words);
11
12        for (int i = 0; i < board.length; i++) {
13            for (int j = 0; j < board[0].length; j++) {
14                dfs(board, i, j, root, res);
15            }
16        }
17        return res;
18    }
19
20    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
21        char c = board[i][j];
22        if (c == '#') return; 
23        
24        if (p.children[c - 'a'] == null) return; 
25        
26        p = p.children[c - 'a'];
27            
28        if (p.target != null) {   // 找到了一个单词,add to res
29            res.add(p.target);
30            p.target = null;     // 去重：防止同一个单词被多次添加
31        }
32
33        board[i][j] = '#'; // 标记已访问
34        
35        // 上下左右探索
36        if (i > 0) dfs(board, i - 1, j, p, res);
37        if (j > 0) dfs(board, i, j - 1, p, res);
38        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
39        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
40
41        board[i][j] = c; // 恢复现场, 其他路径可能要用
42    }
43
44    private TrieNode buildTrie(String[] words) {
45        TrieNode root = new TrieNode();
46        for (String word : words) {
47            TrieNode p = root;
48            for (char c : word.toCharArray()) {
49                int i = c - 'a';
50                if (p.children[i] == null) {
51                    p.children[i] = new TrieNode();
52                }
53                p = p.children[i];
54            }
55            p.target = word;
56        }
57        return root;
58    }
59}
60
61/**
62iterate board, check if trie has the certain word
631. build trie
642. dfs
65
66 */