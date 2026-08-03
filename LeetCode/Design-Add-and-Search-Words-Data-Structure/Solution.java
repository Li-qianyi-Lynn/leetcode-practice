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
29        return helper(root, word, 0);
30    
31        
32    }
33
34    private boolean helper(TrieNode node, String word, int index) {
35        // base case
36        if (index == word.length()) {
37            return node.isEnd;
38
39        }
40        if (word.charAt(index) == '.') {
41            for (int i = 0; i < 26; i++) {
42                if (node.children[i] != null) {
43                    if (helper(node.children[i], word, index+1)) {
44                        return true; //只要有一条通了
45                    }
46                }
47            }
48            return false;
49        } else {
50            int n = word.charAt(index) - 'a';
51            if (node.children[n] != null) {
52                return helper(node.children[n], word, index+1);
53
54            } 
55            return false; // 没路就false
56        }
57       
58
59    }
60}
61
62/**
63 * Your WordDictionary object will be instantiated and called as such:
64 * WordDictionary obj = new WordDictionary();
65 * obj.addWord(word);
66 * boolean param_2 = obj.search(word);
67 */