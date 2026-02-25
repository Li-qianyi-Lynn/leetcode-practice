1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int n = nums.length;
4        if (n == 0) return 0;
5        
6        int res = Integer.MAX_VALUE;
7        // prefixSum[i] stores the sum of nums[0...i-1]
8        int[] prefixSum = new int[n + 1];
9        for (int i = 1; i <= n; i++) {
10            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
11        }
12
13        for (int i = 0; i < n; i++) {
14            // Find the smallest j such that prefixSum[j] - prefixSum[i] >= target
15            // Which is prefixSum[j] >= target + prefixSum[i]
16            int toFind = target + prefixSum[i];
17            int bound = binarySearch(prefixSum, i + 1, n, toFind);
18            
19            if (bound != -1) {
20                res = Math.min(res, bound - i);
21            }
22        }
23
24        return res == Integer.MAX_VALUE ? 0 : res;
25    }
26
27    private int binarySearch(int[] arr, int left, int right, int target) {
28        int res = -1;
29        while (left <= right) {
30            int mid = left + (right - left) / 2;
31            if (arr[mid] >= target) {
32                res = mid;
33                right = mid - 1; // Try to find a smaller index
34            } else {
35                left = mid + 1;
36            }
37        }
38        return res;
39    }
40}