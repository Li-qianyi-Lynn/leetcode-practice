1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        // use map to restore the count of each integer
4        Map<Integer, Integer> count = new HashMap<>();
5        for (int num : nums) {
6            count.put(num,count.getOrDefault(num,0) +1);
7        }
8        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
9        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
10            int fre = entry.getValue();
11            int num = entry.getKey();
12            int[] element = new int[]{fre,num};
13
14            heap.offer(element);
15            if (heap.size() > k) {
16                heap.poll();
17
18            }
19
20        }
21        int[] res = new int[k];
22        for (int i = 0; i < k; i++) {
23            res[i] = heap.poll()[1];
24
25        }
26        return res;
27        
28        
29    }
30}