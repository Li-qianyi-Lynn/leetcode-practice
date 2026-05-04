1class Solution {
2    List<String> res = new ArrayList<>();
3
4    public List<String> letterCombinations(String digits) {
5        Map<Character, String> map = new HashMap<>();
6        map.put('2',"abc");
7        map.put('3',"def");
8        map.put('4',"ghi");
9        map.put('5',"jkl");
10        map.put('6',"mno");
11        map.put('7',"pqrs");
12        map.put('8',"tuv");
13        map.put('9',"wxyz");
14
15        int idx = 0;
16        StringBuilder sb = new StringBuilder();
17        backtracking(digits,0,map,sb);
18        return res;
19        
20    }
21
22    private void backtracking(String digits, int idx, Map<Character, String> map, StringBuilder sb) {
23        //base case
24        if (idx == digits.length()) {
25            res.add(sb.toString());
26            return;
27        }
28
29        // recursive rules
30        char[] letters = map.get(digits.charAt(idx)).toCharArray();
31        for (int i = 0; i < letters.length; i++) {
32            sb.append(letters[i]);
33            backtracking(digits, idx+1, map,sb);
34            sb.deleteCharAt(sb.length()-1);
35
36        }
37
38    }
39}
40
41/**
42
43backtracking
44
45 */