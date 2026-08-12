1class Solution {
2    public int maxProduct(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7
8        int max = nums[0];
9        int min = nums[0];
10        int res = max;
11
12        for (int i = 1; i < nums.length; i++) {
13            int preMax = max;
14         
15
16            max = Math.max(nums[i], Math.max(max * nums[i],min * nums[i]));
17            min = Math.min(nums[i], Math.min(preMax * nums[i],min * nums[i]));
18            res = Math.max(res, max);
19
20        }
21        return res;
22    }
23}
24/**
25input: int[] nums
26output: largest product
27
28+ * +
29+ * - -
30- * - +
31
32
33 */