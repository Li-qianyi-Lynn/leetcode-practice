1
2class Solution {
3    public int networkDelayTime(int[][] times, int n, int k) {
4        // 1. 构建邻接表
5        Map<Integer, List<int[]>> adj = new HashMap<>();
6        for (int[] time : times) {
7            adj.putIfAbsent(time[0], new ArrayList<>());
8            adj.get(time[0]).add(new int[]{time[1],time[2]});
9        }
10  
11        // // 2. 初始化距离数组，全部设为最大值 memo
12        int[] memo = new int[n+1];
13        Arrays.fill(memo, Integer.MAX_VALUE);
14        memo[k] = 0;
15
16        // // 3. 优先队列：按时间(dist)从小到大排序
17        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
18        pq.offer(new int[]{0,k});
19
20        while (!pq.isEmpty()) {
21            int[] poll = pq.poll();
22            int dis = poll[0];
23            int node = poll[1];
24
25
26            if (dis > memo[node]) {
27                continue;
28
29            }
30
31            if (adj.containsKey(node)) {
32                for (int[] nei : adj.get(node)) {
33                    int nextNode = nei[0];
34                    int weight = nei[1];
35
36                    if (memo[node] + weight < memo[nextNode]) {
37                        memo[nextNode] = memo[node] + weight;
38                        pq.offer(new int[]{memo[nextNode], nextNode});
39
40                    }
41
42                }
43
44            }
45        }
46
47           
48    
49       
50
51    int res = 0;
52    for (int i = 1; i <= n; i++) {
53        if (memo[i] == Integer.MAX_VALUE) {
54            return -1;
55        }
56        res = Math.max(res, memo[i]);
57    }
58    return res;
59
60    }
61}