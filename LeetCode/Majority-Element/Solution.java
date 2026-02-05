1class Solution {
2    public int majorityElement(int[] nums) {
3        Map<Integer, Integer> map = new HashMap<>();
4        for (int num : nums) {
5            map.put(num, map.getOrDefault(num,0)+1);
6        }
7
8        int target = nums.length / 2;
9        for (var entry : map.entrySet()) {
10            if (entry.getValue() > target) {
11                return entry.getKey();
12
13            }
14
15        }
16        return 0;
17        
18
19
20        
21    }
22}