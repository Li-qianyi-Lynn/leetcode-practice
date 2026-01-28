1class Solution {
2    public long countOperationsToEmptyArray(int[] nums) {
3        Map<Integer, Integer> pos = new HashMap<>();
4        long n = nums.length, res = n;
5        for (int i = 0; i < n; ++i)
6            pos.put(nums[i], i);
7        Arrays.sort(nums);
8        for (int i = 1; i < n; ++i)
9            if (pos.get(nums[i]) < pos.get(nums[i - 1]))
10                res += n - i;
11        return res;
12        
13    }
14}