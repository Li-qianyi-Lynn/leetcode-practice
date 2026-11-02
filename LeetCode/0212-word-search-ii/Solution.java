class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();

        List<String> res = new ArrayList<>(); // use dfs to update res
        int m = board.length;
        int n = board[0].length;
        for (String word : words) {
            trieBuilder(word,trie);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n;j++) {
                dfs(board,i,j, res,trie); 
            }

        }
        return res;   
    }

    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode trie) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // base case '#'
        char c = board[i][j];
        int index = c - 'a';
        if (c == '#' || trie.children[c - 'a'] == null) {
            return;
        }

        // 移动到子节点!
        TrieNode nextNode = trie.children[c - 'a'];

        if (nextNode.word != null) {
            res.add(nextNode.word);
            nextNode.word = null; 
        }


        char temp = board[i][j];
        board[i][j] = '#';

       for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            // 统一判断边界
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                dfs(board, newI, newJ, res, nextNode);
            }
        }
        board[i][j] = temp;

    }

    private void trieBuilder(String word, TrieNode trie) { // 遍历char in words , put chars in the trieNode
        TrieNode cur = trie;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (index >= 26 || index < 0) {
                return;
            }

            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;

    }
}
/**
trienode class
{
children: TrieNode[26]
String word
}

triebuilder: init trie based on the words

dfs: iterate board 去判断board【i】【j】 char 有没有符合trie
4 directions


root
0 1 2 ...18. 25
           0 ....25 
           0 .. 25
 */