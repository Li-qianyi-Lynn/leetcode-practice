1class TrieNode {
2    TrieNode[] children = new TrieNode[26];
3    boolean isEnd = false;
4}
5
6class Trie {
7    TrieNode root;
8
9    public Trie() {
10        root = new TrieNode();
11        
12    }
13    
14    public void insert(String word) {
15        TrieNode node = root;
16        for (char c : word.toCharArray()) {
17            int idx = c - 'a';
18            if (node.children[idx] == null) {
19                node.children[idx] = new TrieNode();
20
21            }
22            node = node.children[idx];
23
24        }
25        node.isEnd = true;
26        
27    }
28    
29    public boolean search(String word) {
30        TrieNode node = root;
31        for (char c : word.toCharArray()) {
32            int idx = c - 'a';
33            if (node.children[idx] == null) {
34                return false;
35            }
36            node = node.children[idx];
37        }
38        return node.isEnd;
39
40        
41    }
42    
43    public boolean startsWith(String prefix) {
44        TrieNode node = root;
45        for (char c : prefix.toCharArray()) {
46            int idx = c - 'a';
47            if (node.children[idx] == null) {
48                return false;
49            }
50            node = node.children[idx];
51        }
52        return true;
53        
54    }
55
56    
57}
58
59/**
60 * Your Trie object will be instantiated and called as such:
61 * Trie obj = new Trie();
62 * obj.insert(word);
63 * boolean param_2 = obj.search(word);
64 * boolean param_3 = obj.startsWith(prefix);
65 */