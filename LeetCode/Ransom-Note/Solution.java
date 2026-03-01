1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        /**
4        magazine hashmap: char -> count
5        
6         */
7
8        HashMap<Character, Integer> map = new HashMap<>();
9        for (char c : magazine.toCharArray()) {
10            map.put(c, map.getOrDefault(c,0)+1);
11        }
12
13        for (char c : ransomNote.toCharArray()) {
14            if (map.containsKey(c) && map.get(c)> 0) {
15                map.put(c, map.get(c)-1);
16            } else {
17                return false;
18            }
19
20        }
21        return true;
22    }
23}
24
25