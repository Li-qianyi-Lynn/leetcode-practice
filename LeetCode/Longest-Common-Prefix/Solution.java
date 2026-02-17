1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        String prefix = strs[0];
4        for (int i = 1; i < strs.length; i++) {
5            int j = 0; // pointer for comparing
6            while (j < Math.min(strs[i].length(), prefix.length())) {
7                if (strs[i].charAt(j) != prefix.charAt(j)) {
8                    break;
9
10                }
11
12                j++;
13
14            }
15            prefix = prefix.substring(0,j);
16
17        }
18        return prefix;
19        
20    }
21}