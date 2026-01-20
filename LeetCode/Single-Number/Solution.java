1class Solution {
2    public int singleNumber(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7        Set<Integer> set = new HashSet<>();
8        int sum = 0;
9        int duplicate = 0;
10        for (int num : nums) {
11            if (set.contains(num)) {
12                duplicate += num;
13
14            }
15            set.add(num);
16            sum += num;
17
18        }
19        return sum - 2* duplicate;
20        
21    }
22}
23
24/**
25
26tc:O(n)
27sc:O(1)
28
29 */