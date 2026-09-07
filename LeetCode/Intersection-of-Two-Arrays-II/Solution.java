1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3        List<Integer> list = new ArrayList<>();
4        HashMap<Integer, Integer> map1 = new HashMap<>();
5        HashMap<Integer, Integer> map2 = new HashMap<>();
6
7        for (int num : nums1) {
8            map1.put(num, map1.getOrDefault(num,0)+1);
9
10        }
11
12        for (int num : nums2) {
13            map2.put(num, map2.getOrDefault(num,0)+1);
14        }
15
16        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
17            int num = entry.getKey();
18            int freq = entry.getValue();
19
20            if (map2.containsKey(num)) {
21                int minFreq = Math.min(freq, map2.get(num));
22                while (minFreq != 0) {
23                    list.add(num);
24                    minFreq--;
25                }
26            }
27
28        }
29
30        int[] res = new int[list.size()];
31        for (int i = 0; i < res.length; i++) {
32            res[i] = list.get(i);
33
34        }
35
36        return res;
37
38        
39    }
40}
41/**
42List<>
43map1: num -> freq
44map2: num -> freq
45
46
47
48
49 */