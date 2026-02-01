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
29        // base case '#'
30        char c = board[i][j];
31        int index = c - 'a';
32        if (c == '#' || trie.children[c - 'a'] == null) {
33            return;
34        }
35
36        // 1. 核心修改：移动到子节点
37        TrieNode nextNode = trie.children[c - 'a'];
38
39        // 2. 核心修改：从子节点中提取单词
40        if (nextNode.word != null) {
41            res.add(nextNode.word);
42            nextNode.word = null; // 找到后置空，防止重复添加
43        }
44
45
46        char temp = board[i][j];
47        board[i][j] = '#';
48
49        if (i > 0) {
50            dfs(board, i-1,j,res,nextNode);
51        }
52        if (i < board.length-1) {
53            dfs(board, i+1, j,res,nextNode);
54        }
55
56        if (j > 0) {
57            dfs(board,i,j-1,res,nextNode);
58        }
59
60        if (j < board[0].length-1) {
61            dfs(board,i,j+1,res,nextNode);
62
63        }
64        board[i][j] = temp;
65
66    }
67
68    private void trieBuilder(String word, TrieNode trie) { // 遍历char in words , put chars in the trieNode
69        TrieNode cur = trie;
70        for (char c : word.toCharArray()) {
71            int index = c - 'a';
72            if (index >= 26 || index < 0) {
73                return;
74            }
75
76            if (cur.children[index] == null) {
77                cur.children[index] = new TrieNode();
78            }
79            cur = cur.children[index];
80        }
81        cur.word = word;
82
83    }
84}
85/**
86trienode class
87{
88children: TrieNode[26]
89String word
90}
91
92triebuilder: init trie based on the words
93
94dfs: iterate board 去判断board【i】【j】 char 有没有符合trie
954 directions
96
97
98root
990 1 2 ...18. 25
100           0 ....25 
101           0 .. 25
102 */