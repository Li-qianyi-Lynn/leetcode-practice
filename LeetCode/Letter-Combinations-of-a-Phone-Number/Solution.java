1class Solution {
2    List<String> res = new ArrayList<>();
3    public List<String> letterCombinations(String digits) {
4        HashMap<Character, String> map = new HashMap<>();
5        // hashmap: digit -> char
6        map.put('2',"abc");
7        map.put('3',"def");
8        map.put('4',"ghi");
9        map.put('5',"jkl");
10        map.put('6',"mno");
11        map.put('7',"pqrs");
12        map.put('8',"tuv");
13        map.put('9',"wxyz");
14
15        StringBuilder sb = new StringBuilder();
16        backtracking(digits, sb, 0, map); //todo
17        return res;
18    
19        //backtracking base case
20        
21    }
22
23    private void backtracking(String digits, StringBuilder sb, int digitIdx, HashMap<Character, String> map) {
24        //base case
25        if (sb.length() == digits.length()) {
26            res.add(sb.toString());
27            return;
28        }
29
30        char[] cur = map.get(digits.charAt(digitIdx)).toCharArray(); // [a,b,c]
31        for (char c : cur) {
32            backtracking(digits, sb.append(c), digitIdx+1, map); // todo
33            sb.deleteCharAt(sb.length()-1);
34        }
35
36    }
37}
38
39/**
40input: String 
41output: List<String> 
42
43
44
45 */