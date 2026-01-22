1class TrieNode {
2    TrieNode[] children = new TrieNode[26];
3    boolean isEnd = false;
4}
5
6class Trie {
7    private TrieNode root;
8
9    public Trie() {
10        root = new TrieNode();    
11    }
12    
13    public void insert(String word) {
14        TrieNode node = root; // 定一个指针
15        for (int i = 0; i < word.length(); i++) {
16            char c = word.charAt(i);
17            int index = c - 'a';
18            if (node.children[index] == null) {
19                node.children[index] = new TrieNode();
20
21            }
22            node = node.children[index];// 移交给下一个
23        }
24        node.isEnd = true;   
25    }
26    
27    public boolean search(String word) {
28        TrieNode node = root; // 定一个指针
29        for (char c : word.toCharArray()) {
30            int index = c - 'a';
31            if (node.children[index] == null) {
32                return false;
33            }
34        
35            node = node.children[index];
36        }
37        return node.isEnd;
38        
39        
40    }
41    
42    public boolean startsWith(String prefix) {
43        TrieNode node = root;
44        for (char c : prefix.toCharArray()) {
45            int index = c - 'a';
46            if (node.children[index] == null) {
47                return false;
48            }
49            node = node.children[index];
50
51        }
52        
53        return true;
54    }
55}
56
57/**
58 * Your Trie object will be instantiated and called as such:
59 * Trie obj = new Trie();
60 * obj.insert(word);
61 * boolean param_2 = obj.search(word);
62 * boolean param_3 = obj.startsWith(prefix);
63 */
64
65 /**
66 String 
67
68 root -> a -> p -> p -> l ->e  int[26]
69 end or not boolean
70 
71 
72  */