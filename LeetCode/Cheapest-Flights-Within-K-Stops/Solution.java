1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        Map<Integer, List<int[]>> map = new HashMap<>();
4        for (int[] flight : flights) {
5            map.putIfAbsent(flight[0], new ArrayList<>());
6            map.get(flight[0]).add(new int[]{flight[1],flight[2]});
7        }
8
9
10        Deque<int[]> dq = new ArrayDeque<>();
11        dq.offerLast(new int[]{src,0});
12
13        int[] minDist = new int[n];
14        Arrays.fill(minDist, Integer.MAX_VALUE);
15        minDist[src] = 0;
16
17        int stops = 0;
18        while (!dq.isEmpty() && stops <= k) {
19            int size = dq.size();
20            for (int i = 0; i < size; i++) {
21                int[] cur = dq.pollFirst();
22                int toCity = cur[0];
23                int cost = cur[1];
24                if (map.containsKey(toCity)) {
25                    for (int[] edge : map.get(toCity)) {
26                        int toNext = edge[0];
27                        int price = edge[1];
28
29                        if (cost + price < minDist[toNext]) {
30                            minDist[toNext] = cost + price;
31                            dq.offerLast(new int[]{toNext, minDist[toNext]});
32
33                        }
34                    }
35
36                }
37                
38
39            }
40            stops ++;
41
42        }
43
44        return minDist[dst] == Integer.MAX_VALUE ? -1 :minDist[dst];
45        
46        
47    }
48}