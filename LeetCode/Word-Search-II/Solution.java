1class Solution {
2    class TrieNode {
3        TrieNode[] children = new TrieNode[26];
4        String word = null;
5    }
6
7
8    public List<String> findWords(char[][] board, String[] words) {
9        TrieNode trie = new TrieNode();
10
11        List<String> res = new ArrayList<>(); // use dfs to update res
12        int m = board.length;
13        int n = board[0].length;
14        for (String word : words) {
15            trieBuilder(word,trie);
16        }
17
18
19        for (int i = 0; i < m; i++) {
20            for (int j = 0; j < n;j++) {
21                dfs(board,i,j, res,trie); 
22            }
23
24        }
25        return res;   
26    }
27
28    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode trie) {
29        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
30        // base case '#'
31        char c = board[i][j];
32        int index = c - 'a';
33        if (c == '#' || trie.children[c - 'a'] == null) {
34            return;
35        }
36
37        // 移动到子节点!
38        TrieNode nextNode = trie.children[c - 'a'];
39
40        if (nextNode.word != null) {
41            res.add(nextNode.word);
42            nextNode.word = null; 
43        }
44
45
46        char temp = board[i][j];
47        board[i][j] = '#';
48
49       for (int[] dir : dirs) {
50            int newI = i + dir[0];
51            int newJ = j + dir[1];
52            
53            // 统一判断边界
54            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
55                dfs(board, newI, newJ, res, nextNode);
56            }
57        }
58        board[i][j] = temp;
59
60    }
61
62    private void trieBuilder(String word, TrieNode trie) { // 遍历char in words , put chars in the trieNode
63        TrieNode cur = trie;
64        for (char c : word.toCharArray()) {
65            int index = c - 'a';
66            if (index >= 26 || index < 0) {
67                return;
68            }
69
70            if (cur.children[index] == null) {
71                cur.children[index] = new TrieNode();
72            }
73            cur = cur.children[index];
74        }
75        cur.word = word;
76
77    }
78}
79/**
80trienode class
81{
82children: TrieNode[26]
83String word
84}
85
86triebuilder: init trie based on the words
87
88dfs: iterate board 去判断board【i】【j】 char 有没有符合trie
894 directions
90
91
92root
930 1 2 ...18. 25
94           0 ....25 
95           0 .. 25
96 */