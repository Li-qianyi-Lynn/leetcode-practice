1class Solution {
2    public List<String> letterCombinations(String digits) {
3        List<String> res = new ArrayList<>();
4        StringBuilder sb = new StringBuilder();
5        Map<Character, String> map = new HashMap<>();
6        map.put('2', "abc");
7        map.put('3', "def");
8        map.put('4', "ghi");
9        map.put('5', "jkl");
10        map.put('6', "mno");
11        map.put('7', "pqrs");
12        map.put('8', "tuv");
13        map.put('9', "wxyz");
14
15        backtracking(digits, res, sb, map, 0);
16        return res;
17
18        
19    }
20
21    private void backtracking(String digits, List<String> res, StringBuilder sb, Map<Character, String> map, int index) {
22        // base case
23        if (sb.length() == digits.length()) {
24            res.add(sb.toString());
25            return;
26        }
27
28        String letters = map.get(digits.charAt(index));
29        for (int i = 0; i < letters.length(); i++) { 
30            sb.append(letters.charAt(i));
31            backtracking(digits, res, sb, map, index+1); // select the next char
32            sb.deleteCharAt(sb.length()-1);
33
34        }
35
36    }
37}
38/**
392: abc
403: def
41
42[String.string.string..]
43Map: map the relationship between int and char
44
45find one of digit -> find the mapping char(based on the map)-> build the string (temp res.length == digits.length)
46backtracking: same pattern to build the result
471.  base case:  when temp.length == digits.length  return
482.  for loop to iterate  digits mapping String
493.  add char -> backtracking(index+1) -> remove the value we added and restart
50
51 */