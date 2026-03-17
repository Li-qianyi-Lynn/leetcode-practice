1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        Set<String> set = new HashSet<>(wordDict);
4        Deque<Integer> dq = new ArrayDeque<>();
5        boolean[] visited = new boolean[s.length()+1]; // all false
6        dq.offerLast(0);
7
8        while (!dq.isEmpty()) {
9            int start = dq.pollFirst();
10            // base case
11            if (start == s.length()) {
12                return true;
13            }
14
15            for (int end = start+1; end <= s.length(); end++) {
16                if (visited[end]) {
17                    continue;
18
19                }
20                String target = s.substring(start, end);
21                if (set.contains(target)) {
22                    dq.offerLast(end);
23                    visited[end] = true;
24                }
25
26            }
27
28        }
29        return false;
30
31        
32    }
33}
34
35/**
36bfs
37boolean visited: 判断 end 有没有被用过
38
39dq.offerLast(start) 
40start, end 去构造word
41
42for: (start, end)
43判断end
44
45word= s.subString(start, end)
46判断word 是不是在wordDict
47
48dq.pullFirst(end)
49visited[end] = true
50
51 */
52