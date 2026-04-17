1class Solution {
2    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
3        Deque<Integer> dq = new ArrayDeque<>();
4        Set<Integer> set = new HashSet<>();
5        // init.
6        dq.offerLast(0);
7        set.add(0);
8        int n = rooms.size();
9
10        // bfs
11        while (!dq.isEmpty()) {
12            int cur = dq.pollFirst();
13            // get keys;
14            for (int key : rooms.get(cur)) {
15                if (!set.contains(key)) {
16                    set.add(key);
17                    dq.offerLast(key);
18                }
19            }
20
21        }
22        return n == set.size();
23        
24    }
25}
26/**
27input: List<List<Integer>>
28output: boolean: true if you can visit all the rooms, or false otherwise
29
30high level idea:
31bfs-> dq(queue) -> store the room that we can unlock
32
33room num -> use rooms to get the keys -> add these keys into dq
34
35set: dedup 
36
37
38
39
40
41 */