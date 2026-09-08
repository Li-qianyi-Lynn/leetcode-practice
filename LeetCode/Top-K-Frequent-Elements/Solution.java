1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        int[] res = new int[k];
4        int len = nums.length;
5        HashMap<Integer, Integer> map = new HashMap<>();
6        for (int num : nums) {
7            map.put(num, map.getOrDefault(num,0)+1);
8        }
9
10        List<Integer>[] bucket = new List[len + 1];
11        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
12            int num = entry.getKey();
13            int freq = entry.getValue();
14            if (bucket[freq] == null) {
15                bucket[freq] = new ArrayList<>();
16            }
17            bucket[freq].add(num);
18
19    
20        }
21
22        for (int i = len; i >= 0; i--) {
23            if (bucket[i] != null && k > 0) {
24                for (int bu : bucket[i]) {
25                    res[k-1] = bu;
26                    k--;
27
28                }
29            }
30
31        }
32        return res;
33        
34    }
35}
36
37/**
38bucket sort
39
40map: num -> freq
41int[len+1] bucket -> 
42i: freq 
43bucket[i] : num
44
45from end to the begining
46if bucket[i] != null, add bucket[i] to the res
47
48
49
50 */