1class Solution {
2    public double findMaxAverage(int[] nums, int k) {
3        double res = Integer.MIN_VALUE;
4        // step1 : get the base line -> previous k elements;
5        double cur = 0;
6        for (int i = 0; i < k; i++) {
7            cur += nums[i];
8        }
9        res = cur; // base line
10        // step2 : move the slide window
11        for (int i = k; i < nums.length; i++) {
12            cur += nums[i];
13            cur -= nums[i-k];
14            res = Math.max(res, cur);
15        }
16        return res / k;
17        
18    }
19}
20/**
2110 to power of -5
22input： int arry nums[], int k
23output: double   maximum average value  -> max sum of sub array
24
25find a subarry with len == k 
26high level idea: slide window -> get the max sum and update the max sum
27
281,12,-5,-6,50,3
29|.        |
30            k: add nums[i], delete nums[i-k]
31
32 */