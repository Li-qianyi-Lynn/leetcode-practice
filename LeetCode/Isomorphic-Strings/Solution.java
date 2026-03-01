1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        if (s.length() != t.length()) {
4            return false;
5
6        }
7        Map<Character, Integer> mapS = new HashMap<>();
8        Map<Character, Integer> mapT = new HashMap<>();
9
10        for (int i = 0; i < s.length(); i++) {
11            char charS = s.charAt(i);
12            char charT = t.charAt(i);
13            
14            if (!(mapS.getOrDefault(charS,-1)).equals(mapT.getOrDefault(charT,-1))) {
15                return false;
16
17            }
18            mapS.put(charS, i);
19            mapT.put(charT, i);
20            
21        }
22        return true;
23        
24    }
25}
26
27/**
28we need check whether these two strings have same pattern or not.
29
30store the index 
31s.charAt(i) 
32
33char -> index
34
35
36
37
38
39 */