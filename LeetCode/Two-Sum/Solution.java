1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int[] res = new int[2];
5        for (int i = 0; i < nums.length; i++) {
6            
7            if (map.containsKey(target - nums[i])) {
8                res[0] = i;
9                res[1] = map.get(target - nums[i]);
10
11            }
12            map.put(nums[i],i);
13
14        }
15        return res;
16        
17    }
18}
19/**
20
21map: num -> index
22
23 */