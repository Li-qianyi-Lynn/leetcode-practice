1class Solution {
2    public List<String> letterCombinations(String digits) {
3        List<String> res = new ArrayList<>();
4        Map<Character, String> map = new HashMap<>();
5        map.put('2',"abc");
6        map.put('3',"def");
7        map.put('4',"ghi");
8        map.put('5',"jkl");
9        map.put('6', "mno");
10        map.put('7', "pqrs");
11        map.put('8',"tuv");
12        map.put('9',"wxyz");
13        StringBuilder sb = new StringBuilder();
14        backtracking(res, sb, digits, 0, map);
15        return res;
16           
17    }
18
19    private void backtracking(List<String> res, StringBuilder sb, String digits, int idx, Map<Character, String> map) {
20        // base case
21        if (sb.length() == digits.length()) {
22            res.add(sb.toString());
23            return;
24
25        }
26
27        // rules
28        String temp = map.get(digits.charAt(idx));
29        for (int i = 0; i < temp.length(); i++) {
30            sb.append(temp.charAt(i));
31            backtracking(res, sb, digits, idx+1, map);
32            sb.deleteCharAt(sb.length()-1);
33
34
35        }
36    }
37}
38/**
39hashmap
40
41int: String
42
43backtracking
44
45
46
47
48
49 */