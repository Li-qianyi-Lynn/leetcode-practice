1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length() != t.length()) {
4            return false;
5
6        }
7        Map<Character, Integer> maps = new HashMap<>();
8        Map<Character, Integer> mapt = new HashMap<>();
9
10        for (int i = 0; i < s.length(); i++) {
11            char cs = s.charAt(i);
12            char ct = t.charAt(i);
13            maps.put(cs, maps.getOrDefault(cs,0)+1);
14            mapt.put(ct, mapt.getOrDefault(ct,0)+1);
15        }
16
17        return maps.equals(mapt);
18
19
20        
21    }
22}