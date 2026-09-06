1class Solution {
2    public int firstUniqChar(String s) {
3        HashMap<Character, Integer> map = new HashMap<>();
4        int res = -1;
5        for (int i = 0; i < s.length(); i++) {
6            char c = s.charAt(i);
7            map.put(c, map.getOrDefault(c,0)+1);
8        }
9
10        for (int i = 0; i < s.length(); i++) {
11            char c = s.charAt(i);
12            if (map.get(c) == 1) {
13                return i;
14
15            }
16
17        }
18        return res;
19        
20    }
21}