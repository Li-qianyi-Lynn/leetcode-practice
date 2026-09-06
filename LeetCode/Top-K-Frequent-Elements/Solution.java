1
2
3class Solution {
4    public int[] topKFrequent(int[] nums, int k) {
5        HashMap<Integer, Integer> map = new HashMap<>();
6        for (int num : nums) {
7            map.put(num, map.getOrDefault(num,0)+1);
8        }
9
10        int[] res = new int[k];
11        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
12        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
13            int freq = entry.getValue();
14            int num = entry.getKey();
15            int[] cur = new int[]{num, freq};
16
17            if (minHeap.size() < k) {
18                minHeap.offer(cur);
19            } else {
20                if (minHeap.peek()[1] < freq) {
21                    minHeap.poll();
22                    minHeap.offer(cur);
23                }
24            }
25        }
26        for (int i = 0; i < k; i++) {
27            res[i] = minHeap.poll()[0];
28        }
29        return res;   
30    }
31}
32
33/**
34
35
36heap <Integer, freq>
37
38
39
40 */