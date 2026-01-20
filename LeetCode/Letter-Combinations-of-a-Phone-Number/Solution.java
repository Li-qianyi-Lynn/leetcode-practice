1class Solution {
2    
3
4    public List<String> letterCombinations(String digits) {
5        Map<Character, String> map = new HashMap<>();
6        map.put('2', "abc");
7        map.put('3', "def");
8        map.put('4', "ghi");
9        map.put('5', "jkl");
10        map.put('6', "mno");
11        map.put('7', "pqrs");
12        map.put('8', "tuv");
13        map.put('9', "wxyz");
14        List<String> res = new ArrayList<>();
15        StringBuilder sb = new StringBuilder();
16        backtracking(map, sb, digits, res, 0); //todo
17
18        return res;     
19    }
20
21    private void backtracking(Map<Character, String> map, StringBuilder cur, String digits,List<String>res, int index) {
22        //base case
23        if (cur.length() == digits.length()) {
24            res.add(cur.toString());
25            return;
26        }
27
28        String temp = map.get(digits.charAt(index));
29        for (int i = 0; i < temp.length(); i++) {
30            cur.append(temp.charAt(i));
31            backtracking(map, cur, digits, res, index+1);
32            cur.deleteCharAt(cur.length()-1);
33
34        }
35
36    }
37}
38
39/**
40map: Character -> String
41iterate digits, for each digits, get the value
42backtrack()
431. base case: sb.size() == digits.length(); add cur sb to res;
442. get mappings string
453. iterate mapping string
46    append charAt(i)
47    backtrack() next num
48    deleteCharAt(len-1);
49
50
51
52 */