1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        Deque<Integer> dq = new ArrayDeque<>(); // to store index n
4        Set<String> set = new HashSet<>(wordDict); // check words m
5        int len = s.length();
6        boolean[] isVisited = new boolean[len+1]; // n
7
8        dq.offerLast(0);
9        while (!dq.isEmpty()) { //o(n)
10            int start = dq.pollFirst();
11            if (start == len) {
12                return true; // s can be segmented 
13            }
14            
15            for(int i = start+1; i <= len; i++) { //i: end index O(n)
16                if (isVisited[i]== true) {
17                        continue;
18                    }
19                String cur = s.substring(start,i);
20                
21                if (set.contains(cur)) {
22                    dq.offerLast(i);
23                    isVisited[i] = true;
24                }
25            }
26        }
27        return false;  
28    }
29}
30// leetcode. [le, leet, code]
31/**
32dq:0
33
34bfs to check if we can go from the index 0 in String s -> index end in String s
35dq: store the idx -> build cur string using substring
36
37set: check if we have this word in the dict
38map: to optimize , store we visit this end index or not
39
40s: l-e-e-t-c-o-d-e
41   0.1 2 3 4 5 6 7
42
43   apple pen apple
44
45 */