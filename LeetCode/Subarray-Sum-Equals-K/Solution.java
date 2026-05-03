1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int res = 0;
4    
5        Map<Integer, Integer> map = new HashMap<>(); // 前缀和->number of subarrays whose sum equals to k
6        map.put(0,1);
7        int pre = 0;
8        for (int i = 0; i < nums.length; i++) {
9            pre += nums[i];
10            
11            int target = pre - k; //prefix[j];
12            if (map.containsKey(target)) {
13                res += map.get(target);
14
15            }
16            map.put(pre,map.getOrDefault(pre,0)+1);
17        }
18        return res;
19        
20    }
21}
22
23/**
24it has negatives, so we can not use slide window, slide window does not know when to move pointers
25k = prefix[i] - prefix[j]
26
27if sum == k, count ++
28
29Hashmap(sum, times)
30res += map.get(sum);
31
32 */