1class Solution {
2    public long maxScore(int[] nums1, int[] nums2, int k) {
3        // step1: pair
4        int n = nums1.length;
5        int[][] pairs = new int[n][2];// [nums1val,num2val]
6        for (int i = 0; i < n; i++) {
7            pairs[i][0] = nums1[i];
8            pairs[i][1] = nums2[i];
9        }
10        // sort
11        Arrays.sort(pairs,(a,b) -> (b[1] - a[1]));
12        long curSum = 0;
13        long maxSum = 0;
14
15        PriorityQueue<Integer> pq = new PriorityQueue<>();// minheap
16        for (int[] pair : pairs) {
17            int n1 = pair[0];
18            int n2 = pair[1];
19            pq.offer(n1);
20            curSum += n1;
21            if (pq.size() > k) {
22                curSum -= pq.poll();
23            }
24            if (pq.size() == k) {
25                maxSum = Math.max(maxSum, curSum * n2);
26            }
27        }
28        return maxSum;
29        
30    }
31}
32/**
33 equal length n
34 input: int[] nums1 nums2 ; int k positive 
35 k : the num we need 
36 output: long max score 
37
38 score:
39 sum * elements from nums1 * int min in nums2
40 min-heap: k elements -> nums1  
41
42
43 1. pairs
44 2. sort -> nums2 large -> small
45   4,2  3,3  2,1  1,3
46
47int curSum 
483. sum :
49   (curSum) * nums2min
50
51max(sum,max)
52
53
54 */