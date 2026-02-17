1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        if (strs.length == 1) {
4            return strs[0];
5        }
6        int n = strs.length;
7        String res = strs[0];
8       
9        
10        
11        for (int i = 1; i < n; i++) {
12            int j = 0;
13            while (j < Math.min(res.length(), strs[i].length())) {
14                if (res.charAt(j) != strs[i].charAt(j)) {
15                    break;
16                }
17                j++;
18            }
19            res = res.substring(0,j);
20            
21        }
22        return res;
23        
24    }
25}