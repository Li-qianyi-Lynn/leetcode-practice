1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length() != t.length()) {
4            return false;
5        }
6        HashMap<Character, Integer> mapS = new HashMap<>();
7        HashMap<Character, Integer> mapT = new HashMap<>();
8        int n = s.length();
9        for (int i = 0; i < n; i++) {
10            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i),0)+1);
11            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0)+1);
12        }
13
14        for (Map.Entry<Character, Integer> entryS : mapS.entrySet()) {
15            char ch = entryS.getKey();
16            int countS = entryS.getValue();
17
18            if (!mapT.getOrDefault(ch, 0).equals(countS)) {
19                return false;
20
21            }
22
23        }
24        return true;
25
26        
27    }
28}