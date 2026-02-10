1class Solution {
2    public int majorityElement(int[] nums) {
3        int canidate = nums[0];
4        int count = 1; // more than n/2
5
6        for (int i = 1; i < nums.length; i++) {
7            if (count == 0) {  
8                canidate = nums[i];
9                count = 1;
10
11            } else if (nums[i] == canidate) {
12                count++;
13
14            } else if (nums[i] != canidate) {
15                count--;
16            }
17
18        }
19        return canidate;
20
21
22        
23    }
24}