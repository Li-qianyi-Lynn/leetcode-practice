1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        Set<String> words = new HashSet<>(wordDict);
4        Deque<Integer> dq = new ArrayDeque<>();
5        boolean[] seen = new boolean[s.length() + 1];
6        dq.add(0);
7
8        while (!dq.isEmpty()) {
9            int start = dq.pollFirst();
10            if (start == s.length()) {
11                return true;
12            }
13
14            for (int end = start + 1; end <= s.length(); end++) {
15                if (seen[end]) {
16                    continue;
17                }
18
19                if (words.contains(s.substring(start, end))) {
20                    dq.offerLast(end);
21                    seen[end] = true;
22                }
23            }
24        }
25
26        return false;
27    }
28}