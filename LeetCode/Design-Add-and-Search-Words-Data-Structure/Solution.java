1class TrieNode {
2    TrieNode[] children = new TrieNode[26];
3    boolean isEnd = false;
4
5}
6class WordDictionary {
7    TrieNode root;
8
9    public WordDictionary() {
10        root = new TrieNode();
11        
12    }
13    
14    public void addWord(String word) {
15        if (word.length() == 0) {
16            return;
17        }
18        TrieNode node = root;
19        for (char c : word.toCharArray()) {
20            int idx = c - 'a';
21            if (node.children[idx] == null) {
22                node.children[idx] = new TrieNode();
23            }
24            node = node.children[idx];
25        }
26        node.isEnd = true;   
27    }
28    
29    public boolean search(String word) {
30        return dfs(word, 0, root);
31        
32    }
33
34    private boolean dfs(String word, int idx, TrieNode node) {
35        //base case
36        if (idx == word.length()) {
37            return node.isEnd;
38        }
39
40        char c = word.charAt(idx);
41        if (c == '.') {
42            for (int i = 0; i < 26; i++) {
43                if (node.children[i] != null && dfs(word, idx+1, node.children[i])){
44                    return true;
45                }
46            }
47            return false;
48        } else {
49            if (node.children[c-'a'] != null) {
50                return dfs(word, idx+1, node.children[c-'a']);
51
52            }
53            return false;
54        }
55
56    }
57}
58
59/**
60 * Your WordDictionary object will be instantiated and called as such:
61 * WordDictionary obj = new WordDictionary();
62 * obj.addWord(word);
63 * boolean param_2 = obj.search(word);
64 */