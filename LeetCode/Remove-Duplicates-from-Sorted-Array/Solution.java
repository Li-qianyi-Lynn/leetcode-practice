1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 1) {
4            return 1;
5
6        }
7
8        int valid = 1;
9        int cur;
10
11        for (cur = 1; cur < nums.length; cur++) {
12            if (nums[cur] != nums[cur-1]) {
13                nums[valid] = nums[cur];
14                valid ++;
15            }
16
17        }
18        return valid;
19        
20    }
21}