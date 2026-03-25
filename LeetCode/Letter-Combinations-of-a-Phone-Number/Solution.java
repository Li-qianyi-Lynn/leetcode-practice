1class Solution {
2    public List<String> letterCombinations(String digits) {
3        StringBuilder sb = new StringBuilder();
4        List<String> res = new ArrayList<>();
5        Map<Character, String> map = new HashMap<>();
6        map.put('2', "abc");
7        map.put('3', "def");
8        map.put('4', "ghi");
9        map.put('5', "jkl");
10        map.put('6', "mno");
11        map.put('7', "pqrs");
12        map.put('8', "tuv");
13        map.put('9', "wxyz");
14        backtracking(digits, sb, res, 0, map);
15        return res;
16
17
18        
19    }
20
21    private void backtracking(String digits, StringBuilder sb, List<String> res, int index, Map<Character, String> map) {
22        // base case
23        if (sb.length() == digits.length()) {
24            res.add(sb.toString());
25            return;
26
27        }
28        String cur = map.get(digits.charAt(index));
29        for (int i = 0; i < cur.length(); i++) { //abc
30            sb.append(cur.charAt(i));
31            backtracking(digits, sb, res, index+1, map); // digits 
32            sb.deleteCharAt(sb.length()-1);
33
34        }
35
36    }
37}
38
39/**
40
41map: char(num) -> String
42build String: pick num in digits, get the char, add the second char 
43backtracking
441. base case: if sb.size() == digits.length(), return 
452. backtracking: iterate mapping string, cur.append ; index +1
463. remove added value, come to next round
47
48 */