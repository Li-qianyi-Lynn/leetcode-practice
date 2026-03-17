1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        Set<String> set = new HashSet<>(wordDict);
4        Deque<Integer> dq = new ArrayDeque<>();
5        int len = s.length();
6        boolean[] isVisited = new boolean[len+1];
7        
8        dq.offerLast(0);
9
10        while (!dq.isEmpty()) {
11            int start = dq.pollFirst();
12            if (start == len) {
13                return true;
14            }
15            for (int i = start+1; i <= len; i++) {
16                if (isVisited[i] == true) {
17                    continue;
18                }
19                String tar = s.substring(start,i);
20                if (set.contains(tar)) {
21                    dq.offerLast(i);
22                    isVisited[i] = true;
23                }
24            }
25
26        }
27        
28        return false;
29    }
30}
31/**
32divided s into diff words that are in worddict
33bfs, start from 0 , check if substring(start,end) in the worddict
34if yes, add to the dq and set as the next start
35
36visited map: reduce dup
37
38
39
40
41 */