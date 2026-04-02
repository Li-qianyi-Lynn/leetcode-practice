1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        Map<Integer, Integer> map = new HashMap<>();
4        int[] res = new int[2];
5        for (int i = 0; i < nums.length; i++) {
6            int t = target - nums[i];
7            if (map.containsKey(t)) {
8                res[0] = i;
9                res[1] = map.get(t);
10                break;
11            }
12            map.put(nums[i],i);
13
14        }
15        return res;
16        
17    }
18}