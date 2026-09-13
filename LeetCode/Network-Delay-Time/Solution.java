1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        HashMap<Integer, List<int[]>> map = new HashMap<>();
4        for (int[] time : times) {
5            map.putIfAbsent(time[0], new ArrayList<>());
6            map.get(time[0]).add(new int[]{time[1],time[2]});
7        }
8
9        int[] dist = new int[n+1];
10        Arrays.fill(dist, Integer.MAX_VALUE);
11        dist[k] = 0;
12
13        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0])); // sort by time       time,k
14
15        minHeap.offer(new int[]{0,k});
16
17        while (!minHeap.isEmpty()) {
18            int[] poll = minHeap.poll();
19            int t = poll[0];
20            int node = poll[1];
21
22            if (dist[node] < t) {
23                continue;
24            }
25
26            if (map.containsKey(node)) {
27                for (int[] nei : map.get(node)) {
28                    // 比较需要的时间和dist 时间
29                    int nextNodeTime = nei[1];
30                    int nextNode = nei[0];
31                    int curTime = nextNodeTime + dist[node];
32                    if (curTime < dist[nextNode]) {
33                        dist[nextNode] = curTime;
34                        minHeap.offer(new int[]{curTime, nextNode});
35                    }   
36                }
37            }
38        }
39        int res = 0;
40        for (int i = 1; i <= n; i++) {
41            if (dist[i] == Integer.MAX_VALUE) {
42                return -1;
43
44            }
45            res = Math.max(res, dist[i]);
46
47        }
48        return res;
49        
50    }
51}
52/**
53
54adj
55
56int[] dist 
57
58pq minheap
59
60res: for loop dist 
61
62 */