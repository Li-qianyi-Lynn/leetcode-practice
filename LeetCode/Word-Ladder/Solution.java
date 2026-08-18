1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3        // edge case
4        HashSet<String> set = new HashSet<>();
5        int size = wordList.size();
6        HashSet<String> visited = new HashSet<>();
7        for (int i = 0; i < size; i++) {
8            set.add(wordList.get(i));
9        }
10
11        if (!set.contains(endWord)) { //+len
12            return 0;
13
14        }
15        Deque<String> dq = new ArrayDeque<>();
16        dq.add(beginWord);
17        visited.add(beginWord);
18        int step = 1;
19        while (!dq.isEmpty()) {
20            int sz = dq.size();
21            for (int k = 0; k < sz; k++) {
22                String cur = dq.pollFirst();
23                // get neibors
24                List<String> list = new ArrayList<>();
25                list = getNei(visited, cur,set); //todo not visited + in hashset
26                for (int i = 0; i < list.size(); i++) {
27                    String next = list.get(i);
28                    if (next.equals(endWord)) {
29                        return step+1;
30                    }
31                    dq.offerLast(next);
32                    
33                }
34
35            } 
36            step++;
37        
38        }
39
40        return 0;    
41    }
42
43    private List<String> getNei(HashSet<String> visited, String word, HashSet<String> set) {
44        char[] cs = word.toCharArray(); // hit
45        List<String> res = new ArrayList<>();
46        for (int i = 0; i < cs.length; i++) {
47            char origin = cs[i];
48            for (char j = 'a'; j <= 'z'; j++) {
49                if (j == origin) {
50                    continue;
51
52                }
53                cs[i] = j;
54                String candidate = String.valueOf(cs);
55                
56                if (set.contains(candidate) && !visited.contains(candidate)) {
57                visited.add(candidate);
58                res.add(candidate);
59
60                }
61
62            }
63         
64            cs[i] = origin;
65           
66        }
67        return res;
68
69    }
70}
71/**
72
73input: 
74output: int num of words
75
76
77set: words in the list
78
79bfs
80deque
81
82hit
83*: any char
84h i t
85
86* -> 26 char -> 
87
88
89
90 */