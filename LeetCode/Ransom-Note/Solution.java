1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        Map<Character, Integer> map = new HashMap<>();
4        for (int i = 0; i < magazine.length(); i++) {
5            char c = magazine.charAt(i);
6            map.put(c, map.getOrDefault(c,0)+1);
7        }
8        for (int i = 0; i < ransomNote.length(); i++) {
9            char c = ransomNote.charAt(i);
10            if (map.containsKey(c) && map.get(c) > 0) {
11                map.put(c, map.get(c)-1);
12
13            } else {
14                return false;
15            }
16
17        }
18        return true;
19
20        
21    }
22}