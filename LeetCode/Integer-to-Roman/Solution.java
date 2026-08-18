1class Solution {
2    public String intToRoman(int num) {
3        StringBuilder sb = new StringBuilder();
4        List<Integer> list = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);        
5        Map<Integer, String> map = new HashMap<>();
6        map.put(1000,"M");
7        map.put(900,"CM");
8        map.put(500,"D");
9        map.put(400,"CD");
10        map.put(100,"C");
11        map.put(90,"XC");
12        map.put(50,"L");
13        map.put(40,"XL");
14        map.put(10,"X");
15        map.put(9,"IX");
16        map.put(5,"V");
17        map.put(4,"IV");
18        map.put(1,"I");
19
20
21
22        for (int i = 0; i < list.size(); i++) {
23            int div = list.get(i);
24            int count = num / div;
25
26            while (count>0) {
27                sb.append(map.get(div));
28                count--;
29            }
30            num = num % div;
31
32        }
33        return sb.toString();
34
35
36        
37    }
38}