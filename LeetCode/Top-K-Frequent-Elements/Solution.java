1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        int[] res = new int[k];
4        // map: store num(key) and its frequency(value)
5        Map<Integer, Integer> map = new HashMap<>();
6        for (int i = 0; i < nums.length; i++) {
7            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
8        }
9        //put K-V pait to the pq, and do the comperation
10        // min heap: heap topwill store the least frequent element, if the size is larger than k, we can just pop out he top
11        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
12        for(Map.Entry<Integer, Integer> pair: map.entrySet()) {
13            int freq = pair.getValue();
14            int num = pair.getKey();
15            int[] element = new int[]{num, freq};
16            pq.offer(element);
17
18            if (pq.size() > k) {
19                pq.poll();
20
21            }
22
23        }
24
25        // add num to the res list;
26        for (int i = 0; i < k; i++) {
27            res[i] = pq.poll()[0];
28
29        }
30        return res;
31        
32    }
33}