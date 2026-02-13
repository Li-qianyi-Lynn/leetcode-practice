1class Solution {
2    public int romanToInt(String s) {
3        int num = 0;
4        Map<Character, Integer> map = new HashMap<>();
5        map.put('I',1);
6        map.put('V',5);
7        map.put('X',10);        
8        map.put('L',50);
9        map.put('C',100);
10        map.put('D',500);
11        map.put('M',1000);
12
13        for (int i = 0; i < s.length(); i++) {
14  
15            if (i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
16                num -= map.get(s.charAt(i));
17            } else {
18                num += map.get(s.charAt(i));
19            }
20
21        }
22        return num;
23        
24    }
25}