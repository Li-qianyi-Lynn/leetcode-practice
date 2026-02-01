1class Solution {
2    class TrieNode {
3        TrieNode[] children = new TrieNode[26];
4        String word = null;
5    }
6   
7    public List<String> findWords(char[][] board, String[] words) {
8        List<String> res = new ArrayList<>();
9        TrieNode root = trieBuilder(words);
10
11        int m = board.length;
12        int n = board[0].length;
13
14        for (int i = 0; i < m; i++) {
15            for (int j = 0; j < n; j++) {
16                dfs(res,i,j,root,board ); //todo
17            }
18
19        }
20        return res;
21       
22    }
23
24    private void dfs(List<String> res, int i, int j, TrieNode node,char[][] board ) {
25        char c = board[i][j];
26        // base case
27        if (c == '#') {
28            return;
29        }
30
31        if (node.children[c-'a']== null) {
32            return;
33
34        }
35
36        node = node.children[c - 'a'];
37        if (node.word != null) {
38            res.add(node.word);
39            node.word = null; // dedup
40        }
41        board[i][j] = '#';
42        if (i > 0) dfs(res, i-1, j, node, board);
43        if (i < board.length-1) dfs(res, i+1,j, node, board);
44        if (j > 0) dfs(res, i, j-1, node, board);
45        if (j < board[0].length-1) dfs(res,i, j+1, node, board);  
46
47        board[i][j] = c;
48
49
50    }
51
52    private TrieNode trieBuilder(String[] words) {
53        TrieNode root = new TrieNode();
54        for (String w : words) {
55            TrieNode cur = root;
56            for (char c : w.toCharArray()) {
57                int index = c - 'a';
58                if (cur.children[index] == null) {
59                    cur.children[index] = new TrieNode();
60                }
61                cur = cur.children[index];
62            }
63            cur.word = w; // 标记word
64        }
65        return root;
66
67
68    }
69
70   
71   
72}
73
74/**
75iterate board, check if trie has the certain word
761. build trie
772. dfs
78
79 */