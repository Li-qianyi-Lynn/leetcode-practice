class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // adj map node -> nei
        HashMap<Integer,List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }


        // minheap: sort by time

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));// time, targetNode
        // int[] dist: to store distance from source to  the node i
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        // process node
        pq.offer(new int[]{0,k});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[1];
            int t = poll[0]; // t+ dist[Node]

            if (dist[node]< t) {
                continue;
            }

            if (adj.containsKey(node)) {
                for (int[] nei : adj.get(node)) {
                    int nexNode = nei[0];
                    int weight = nei[1];

                    if ( weight+ dist[node] < dist[nexNode]) {
                        dist[nexNode] =  weight+ dist[node];
                        pq.offer(new int[]{dist[nexNode], nexNode});
                    }
                }
            }
        }

        // for loop dist to get the max num
        int res = dist[1];
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;

            }
            res = Math.max(res,dist[i]);


        }
        return res;
        
    }
}
/**

1. adj map



 */