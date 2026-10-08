1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int[] res = new int[2];
4        int n = numbers.length;
5
6        int l = 0;
7        int r = n-1;
8
9        while (l < r) {
10            if (numbers[l] + numbers[r]== target) {
11                res[0] = l+1;
12                res[1] = r+1;
13                break;
14        
15
16            } else if (numbers[l] + numbers[r] < target) {
17                l++;
18
19            } else {
20                r--;
21            }
22
23
24        }
25        return res;
26        
27    }
28}