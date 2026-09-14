1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        // adj map node -> nei
4        HashMap<Integer,List<int[]>> adj = new HashMap<>();
5        for (int[] time : times) {
6            adj.putIfAbsent(time[0], new ArrayList<>());
7            adj.get(time[0]).add(new int[]{time[1], time[2]});
8        }
9
10
11        // minheap: sort by time
12
13        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));// time, targetNode
14        // int[] dist: to store distance from source to  the node i
15        int[] dist = new int[n+1];
16        Arrays.fill(dist, Integer.MAX_VALUE);
17        dist[k] = 0;
18        // process node
19        pq.offer(new int[]{0,k});
20        while (!pq.isEmpty()) {
21            int[] poll = pq.poll();
22            int node = poll[1];
23            int t = poll[0]; // t+ dist[Node]
24
25            if (dist[node]< t) {
26                continue;
27            }
28
29            if (adj.containsKey(node)) {
30                for (int[] nei : adj.get(node)) {
31                    int nexNode = nei[0];
32                    int weight = nei[1];
33
34                    if ( weight+ dist[node] < dist[nexNode]) {
35                        dist[nexNode] =  weight+ dist[node];
36                        pq.offer(new int[]{dist[nexNode], nexNode});
37                    }
38                }
39            }
40        }
41
42        // for loop dist to get the max num
43        int res = dist[1];
44        for (int i = 1; i <= n; i++) {
45            if (dist[i] == Integer.MAX_VALUE) {
46                return -1;
47
48            }
49            res = Math.max(res,dist[i]);
50
51
52        }
53        return res;
54        
55    }
56}
57/**
58
591. adj map
60
61
62
63 */