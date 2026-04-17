1class Solution {
2    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
3        int n = rooms.size();
4        Deque<Integer> dq = new ArrayDeque<>(); // rooms we opened
5        boolean[] visited = new boolean[n];
6        int count = 0;
7        visited[0] = true;
8        dq.offerLast(0);
9
10        while (!dq.isEmpty()) {
11            int cur = dq.pollFirst();
12            count++;
13
14            for (int key : rooms.get(cur)) {
15                if (!visited[key]) {
16                    visited[key] = true;
17                    dq.offerLast(key);
18
19                }
20
21            }
22
23        }
24        return count == n;
25
26
27
28        
29        
30    }
31}
32/**
33bfs
34
35
36
37
38 */