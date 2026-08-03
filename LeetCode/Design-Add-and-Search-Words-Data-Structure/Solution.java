1class TrieNode {
2    TrieNode[] children = new TrieNode[26];
3    boolean isEnd = false;
4}
5
6class WordDictionary {
7    private TrieNode root;
8
9
10
11    public WordDictionary() {
12        root = new TrieNode();
13    
14        
15    }
16    
17    public void addWord(String word) { // build tree
18        TrieNode node = root; //pointer to root
19        for (char c : word.toCharArray()) {
20            int i = c - 'a';
21            if (node.children[i] == null) {
22                node.children[i] = new TrieNode();
23            }
24            node = node.children[i];
25        }
26        node.isEnd = true;
27
28        
29    }
30    
31    public boolean search(String word) {// dfs
32        return dfs(word, 0, root);
33        
34    }
35
36    private boolean dfs(String word, int idx, TrieNode node) {
37        //base case
38        if (idx == word.length()) {
39            return node.isEnd;
40        }
41
42        char c = word.charAt(idx);
43        if (c == '.') {
44            for (int i = 0; i < 26; i++) {
45                if (node.children[i] != null && dfs(word, idx+1, node.children[i])){
46                    return true;
47                }
48            }
49            return false;
50        } else {
51            if (node.children[c-'a'] != null) {
52                return dfs(word, idx+1, node.children[c-'a']);
53
54            }
55            return false;
56        }
57
58    }
59}
60
61/**
62 * Your WordDictionary object will be instantiated and called as such:
63 * WordDictionary obj = new WordDictionary();
64 * obj.addWord(word);
65 * boolean param_2 = obj.search(word);
66 */