1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int[] res = new int[2];
4        int r = numbers.length-1;
5        int l = 0;
6
7        while (l < r) {
8            if (l < numbers.length && numbers[r] + numbers[l] < target) {
9                l++;
10            } else if (r >= 0 && numbers[r] + numbers[l] > target) {
11                r--;
12            } else {
13                res[0] = l+1;
14                res[1] = r+1;
15                break;
16            }
17
18        }
19        return res;
20
21        
22    }
23}