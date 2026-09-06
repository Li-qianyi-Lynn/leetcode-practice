1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        // pruning nums.length == 1 return nums
4        if (nums.length == 1) {
5            return nums;
6        }
7        //map: num -> freq
8        HashMap<Integer, Integer> map = new HashMap<>();
9        for (int num : nums) {
10            map.put(num, map.getOrDefault(num, 0)+1);
11        }
12
13        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //todo
14        // iterate the map. put num, freq into pq
15        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
16            int freq = entry.getValue(); 
17            int num = entry.getKey();
18
19            if (pq.size() < k) {
20                pq.offer(new int[]{freq,num});
21
22            } else {
23                if (pq.peek()[0] < freq) {
24                    pq.poll();
25                    pq.offer(new int[]{freq,num});
26                }
27            }
28        }
29        //[4,1],[4,2],[2,3]
30        // build res
31        int[] res = new int[k];
32        for (int i = 0; i < k; i++) {
33            res[i] = pq.poll()[1];
34
35        }
36        return res;     
37    }
38}
39
40/**
41input： int[] nums, int k
42putput: k most frequent elements.  int[] 
43
441->4
452->4
463->2
47
48map: num -> freq
49pq minpq : compare freq 
50 */