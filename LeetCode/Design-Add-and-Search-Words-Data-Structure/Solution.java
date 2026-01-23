1class TrieNode {
2    TrieNode[] children = new TrieNode[26];
3    boolean isEnd = false;
4}
5
6class WordDictionary {
7    private TrieNode root;
8
9    public WordDictionary() {
10        root = new TrieNode();
11        
12    }
13    
14    public void addWord(String word) {
15        TrieNode node = root;
16        for (char c : word.toCharArray()) {
17            int index = c - 'a';
18            if (node.children[index] == null) {
19                node.children[index] = new TrieNode();
20            }
21            node = node.children[index];
22
23        }
24        node.isEnd = true;
25        
26    }
27    
28    public boolean search(String word) {
29        TrieNode node = root;
30        return helper(root, word, 0);
31    
32        
33    }
34
35    private boolean helper(TrieNode root, String word, int index) {
36        // base case
37        if (index >= word.length()) {
38            return root.isEnd;
39
40        }
41        if (word.charAt(index) == '.') {
42            for (int i = 0; i < 26; i++) {
43                if (root.children[i] != null) {
44                    if (helper(root.children[i], word, index+1)) {
45                        return true; //只要有一条通了
46                    }
47                }
48            }
49            return false;
50        } else {
51            int n = word.charAt(index) - 'a';
52            if (root.children[n] != null) {
53                return helper(root.children[n], word, index+1);
54
55            } 
56            return false; // 没路就false
57        }
58       
59
60
61    }
62}
63
64/**
65 * Your WordDictionary object will be instantiated and called as such:
66 * WordDictionary obj = new WordDictionary();
67 * obj.addWord(word);
68 * boolean param_2 = obj.search(word);
69 */