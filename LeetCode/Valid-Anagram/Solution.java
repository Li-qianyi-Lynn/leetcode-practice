1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length() != t.length()) { return false; }
4        Map<Character, Integer> mapS = new HashMap<>();
5        Map<Character, Integer> mapT = new HashMap<>();
6
7        for (int i = 0; i < s.length(); i++) {
8            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i),0)+1);
9            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0)+1);
10
11        }
12
13        return mapS.equals(mapT);
14        
15    }
16}