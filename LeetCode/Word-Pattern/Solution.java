1class Solution {
2    public boolean wordPattern(String pattern, String s) {
3        String[] split = s.split(" ");
4        if (pattern.length() != split.length) {
5            return false;
6
7        }
8
9        Map<Character, Integer> map = new HashMap<>();
10        Map<String, Integer> sMap = new HashMap<>();
11        for (int i = 0; i < split.length; i++) {
12            char c = pattern.charAt(i);
13            int val1 = map.getOrDefault(c, 0);
14            int val2 = sMap.getOrDefault(split[i], 0);
15            if (val1 != val2) {
16            
17                return false;
18
19            }
20            map.put(c, i+1);
21            sMap.put(split[i],i+1);
22
23        }
24        
25        return true;
26
27        
28    }
29}
30
31/**
32a -> 1
33b -> 3
34-------
35dog -> 1
36cat -> 3
37
38 */