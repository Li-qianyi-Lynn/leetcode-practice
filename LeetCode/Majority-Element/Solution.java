1class Solution {
2    public int majorityElement(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7
8        Map<Integer, Integer> map = new HashMap<>();
9        for (int i = 0; i < nums.length; i++) {
10            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
11        }
12
13        int target = nums.length/2;
14
15        for (var entry : map.entrySet()) {
16            if (entry.getValue() > target) {
17                return entry.getKey();
18            }
19        }
20        return 0;
21
22        
23    }
24}
25
26/**
27nums[i] -> count
28
29if value > n/2
30return key
31
32
33 */