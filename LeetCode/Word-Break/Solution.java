1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        int len = s.length();
4        boolean[] isVisited = new boolean[len+1];
5        Set<String> set = new HashSet<>(wordDict);
6        Deque<Integer> dq = new ArrayDeque<>();
7        dq.offerLast(0);
8
9        while (!dq.isEmpty()) {
10            int start =dq.pollFirst();
11            if (start == len) {
12                return true;
13            }
14            for (int i = start; i <= len; i++) {
15                if (isVisited[i]== true) {
16                    continue;
17                }
18                String target = s.substring(start,i);
19                if (set.contains(target)) {
20                    dq.offerLast(i);
21                    isVisited[i] = true;
22                }
23
24            }
25
26        }
27        return false;
28
29        
30    }
31}
32
33/**
34divied string into diff parts
35
36 */