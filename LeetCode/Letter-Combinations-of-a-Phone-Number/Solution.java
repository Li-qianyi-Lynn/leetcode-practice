1class Solution {
2    List<String> res = new ArrayList<>();
3    public List<String> letterCombinations(String digits) {
4        Map<Character, String> map = new HashMap<>();
5        map.put('2',"abc");
6        map.put('3',"def");
7        map.put('4',"ghi");
8        map.put('5',"jkl");
9        map.put('6',"mno");
10        map.put('7',"pqrs");
11        map.put('8',"tuv");
12        map.put('9',"wxyz");
13
14        int index = 0;
15        StringBuilder sb = new StringBuilder();
16        backtracking(index, digits, map, sb);
17
18        return res;
19
20
21        
22        
23        
24    }
25
26    private void backtracking(int index, String digits, Map<Character, String> map, StringBuilder sb) {
27        //base case
28        if (index == digits.length()) {
29            res.add(sb.toString());
30            return;
31        }
32
33        //recursive rules
34        //get char arry
35        char[] arr = map.get(digits.charAt(index)).toCharArray();
36        for (int i = 0; i < arr.length; i++) {
37            sb.append(arr[i]);
38            backtracking(index+1, digits, map, sb);
39            sb.deleteCharAt(sb.length()-1);
40
41        }
42    }
43}
44/**
45input: String
46output: List<String>
47
48int[]: map num -> char
49
50backtracking
511)when to stop: stringbuilder.length() == dights.length()
522)build string
533)recover
54
55
56
57 */