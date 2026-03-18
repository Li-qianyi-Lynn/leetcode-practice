1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        Deque<Integer> dq = new ArrayDeque<>(); // to store index
4        Set<String> set = new HashSet<>(wordDict); // check words
5        int len = s.length();
6        boolean[] isVisited = new boolean[len+1];
7
8        dq.offerLast(0);
9        while (!dq.isEmpty()) {
10            int start = dq.pollFirst();
11            if (start == len) {
12                return true; // s can be segmented 
13            }
14            
15            for(int i = start+1; i <= len; i++) { //i: end index
16                String cur = s.substring(start,i);
17                if (isVisited[i]== true) {
18                    continue;
19                }
20                if (set.contains(cur)) {
21                    dq.offerLast(i);
22                    isVisited[i] = true;
23                }
24            }
25        }
26        return false;  
27    }
28}
29
30/**
31dq:0
32
33bfs to check if we can go from the index 0 in String s -> index end in String s
34dq: store the idx -> build cur string using substring
35
36set: check if we have this word in the dict
37map: to optimize , store we visit this end index or not
38
39s: l-e-e-t-c-o-d-e
40   0.1 2 3 4 5 6 7
41
42   apple pen apple
43
44 */