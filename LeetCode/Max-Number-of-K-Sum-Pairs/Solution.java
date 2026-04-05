1class Solution {
2    public int maxOperations(int[] nums, int k) {
3        Map<Integer,Integer> map = new HashMap<>();
4        int res = 0;
5        for (int num : nums) {
6            int target = k - num;
7            if (map.containsKey(target) && map.get(target) > 0) {
8                res++;
9                map.put(target,map.get(target)-1);
10            } else {
11                map.put(num, map.getOrDefault(num,0)+1);
12            }
13
14        }
15        return res;
16
17        
18    
19        
20    }
21}
22/**
23map:
24
25
26 */