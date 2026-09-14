1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3     
4        // adj map ui -> vi, wi
5        HashMap<Integer, List<int[]>> map = new HashMap<>();
6        for (int[] time : times) {
7            map.putIfAbsent(time[0], new ArrayList<>());
8            map.get(time[0]).add(new int[]{time[1],time[2]});
9        }
10
11        // dist[]: to store nodes distance
12        int[] dist = new int[n+1];
13        Arrays.fill(dist, Integer.MAX_VALUE);
14        dist[k] = 0;
15
16        // pq: minHeap dist[i], node i
17        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
18        pq.offer(new int[]{0,k});
19
20        while (!pq.isEmpty()) {
21            int[] poll = pq.poll();
22            int d = poll[0];
23            int node = poll[1];
24
25            if (d > dist[node]) {
26                continue;
27
28            }
29
30            if (map.containsKey(node)) {
31                for (int[] nei : map.get(node)) {
32                    int nextNode = nei[0];
33                    int weight = nei[1];
34
35                    if (dist[node] + weight < dist[nextNode]) {
36                       dist[nextNode] =  dist[node] + weight;
37                       pq.offer(new int[]{dist[nextNode],nextNode});
38
39
40
41                    }
42
43                }
44
45            }
46        }
47
48
49        // for loop to get res
50
51        int res = 0;
52        for (int i = 1; i < n+1; i++) {
53            if (dist[i] == Integer.MAX_VALUE) {
54                return -1;
55
56            }
57
58            res = Math.max(res, dist[i]);
59
60        }
61        return res;
62        
63    }
64}
65