1class Solution {
2    private List<String> combinations = new ArrayList<>();
3    private Map<Character, String> letters = Map.of(
4        '2',
5        "abc",
6        '3',
7        "def",
8        '4',
9        "ghi",
10        '5',
11        "jkl",
12        '6',
13        "mno",
14        '7',
15        "pqrs",
16        '8',
17        "tuv",
18        '9',
19        "wxyz"
20    );
21    private String phoneDigits;
22
23    public List<String> letterCombinations(String digits) {
24        // If the input is empty, immediately return an empty answer array
25        if (digits.length() == 0) {
26            return combinations;
27        }
28
29        // Initiate backtracking with an empty path and starting index of 0
30        phoneDigits = digits;
31        backtrack(0, new StringBuilder());
32        return combinations;
33    }
34
35    private void backtrack(int index, StringBuilder path) {
36        // If the path is the same length as digits, we have a complete combination
37        if (path.length() == phoneDigits.length()) {
38            combinations.add(path.toString());
39            return; // Backtrack
40        }
41
42        // Get the letters that the current digit maps to, and loop through them
43        String possibleLetters = letters.get(phoneDigits.charAt(index));
44        for (char letter : possibleLetters.toCharArray()) {
45            // Add the letter to our current path
46            path.append(letter);
47            // Move on to the next digit
48            backtrack(index + 1, path);
49            // Backtrack by removing the letter before moving onto the next
50            path.deleteCharAt(path.length() - 1);
51        }
52    }
53}