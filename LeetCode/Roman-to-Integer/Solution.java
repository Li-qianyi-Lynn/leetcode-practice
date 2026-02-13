1class Solution {
2    public int romanToInt(String s) {
3        Map<Character, Integer> map = new HashMap<>();
4        int res = 0;
5         
6        map.put('I',1);
7        map.put('V',5);
8        map.put('X',10);
9        map.put('L',50);
10        map.put('C',100);
11        map.put('D',500);
12        map.put('M',1000);
13
14        for (int i = 0; i < s.length(); i++) {
15            if (i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
16                res -= map.get(s.charAt(i));
17
18            } else {
19                res += map.get(s.charAt(i));
20            }
21
22        }
23        return res;
24
25    }
26}
27/**
28
29map.get(charAt(i) < charAt(i+1)) 
30res - i
31
32 */