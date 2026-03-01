1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        if (s.length() == 1) {
4            return true;
5
6        }
7        Map<Character, Integer> maps = new HashMap<>();
8        Map<Character, Integer> mapt = new HashMap<>();
9
10        for (int i = 0; i < s.length(); i++) {
11            char sc = s.charAt(i);
12            char tc = t.charAt(i);
13            if (maps.getOrDefault(sc,-1).equals(mapt.getOrDefault(tc,-1))) {
14                maps.put(sc,i);
15                mapt.put(tc,i);   
16            } else {
17                return false;
18            }
19        }
20        return true;
21
22
23    }
24
25}
26
27/**
28f 0
291 1
30
31b 0
322 1
33
34f -> b 
351 -> 2
36
37 */