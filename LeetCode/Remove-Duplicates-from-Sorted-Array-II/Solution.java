1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 0) {
4            return 0;
5
6        }
7
8        int base = 1;
9        int valid = 1; //  track position for valid elements
10        int count =1;
11
12        while (base < nums.length) {
13            if (nums[base] == nums[base-1]) {
14                count++;
15                if (count > 2) {
16                    base++;
17                    continue;
18                }
19
20            } else {
21                count =1;
22            }
23            nums[valid] = nums[base];
24            valid++;
25            base++;
26
27        }
28        return valid;
29       
30        
31    }
32}
33
34