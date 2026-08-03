1class TrieNode {
2    TrieNode[] children = new TrieNode[26];
3    boolean isEnd = false;
4}
5class Trie {
6    TrieNode root;
7
8    public Trie() {
9        root = new TrieNode();    
10    }
11    
12    public void insert(String word) {
13        TrieNode cur = root;
14        for (char c : word.toCharArray()) {
15            int idx = c - 'a';
16            if (cur.children[idx] == null) {
17                cur.children[idx] = new TrieNode();
18            }
19            cur = cur.children[idx];
20        } 
21        cur.isEnd = true;
22 
23    }
24    
25    public boolean search(String word) {
26        TrieNode cur = root;
27        for (char c : word.toCharArray()) {
28            int idx = c - 'a';
29            if (cur.children[idx] == null) {
30                return false;    
31            }
32            cur = cur.children[idx];
33        }
34        return cur.isEnd;
35        
36    }
37    
38    public boolean startsWith(String prefix) {
39        TrieNode cur = root;
40        for (char c : prefix.toCharArray()) {
41            int idx = c - 'a';
42            if (cur.children[idx] == null) {
43                return false;    
44            }
45            cur = cur.children[idx];
46        }
47        return true;      
48    }
49}
50
51/**
52 * Your Trie object will be instantiated and called as such:
53 * Trie obj = new Trie();
54 * obj.insert(word);
55 * boolean param_2 = obj.search(word);
56 * boolean param_3 = obj.startsWith(prefix);
57 */