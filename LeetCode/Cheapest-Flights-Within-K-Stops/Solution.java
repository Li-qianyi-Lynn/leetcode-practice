1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        Map<Integer, List<int[]>> map = new HashMap<>();
4        for (int i = 0; i < n; i++) {
5            map.put(i, new ArrayList<>());
6        }
7
8        for (int[] flight : flights) {
9            int f = flight[0];
10            int t = flight[1];
11            int p = flight[2];
12            map.get(f).add(new int[]{t,p});
13        }
14
15        Deque<int[]> dq = new ArrayDeque<>();
16        dq.offerLast(new int[]{src,0});
17
18        int[] minDist = new int[n];
19        Arrays.fill(minDist, Integer.MAX_VALUE);
20        minDist[src] = 0;
21
22        int stops = 0;
23        while (!dq.isEmpty() && stops <= k) {
24            int size = dq.size();
25            for (int i = 0; i < size; i++) {
26                int[] cur = dq.pollFirst();
27                int toCity = cur[0];
28                int cost = cur[1];
29
30                for (int[] edge : map.get(toCity)) {
31                    int toNext = edge[0];
32                    int price = edge[1];
33
34                    if (cost + price < minDist[toNext]) {
35                        minDist[toNext] = cost + price;
36                        dq.offerLast(new int[]{toNext, minDist[toNext]});
37
38                    }
39
40                }
41
42            }
43            stops ++;
44
45        }
46
47        return minDist[dst] == Integer.MAX_VALUE ? -1 :minDist[dst];
48        
49        
50    }
51}