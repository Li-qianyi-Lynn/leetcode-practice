1class Solution {
2    public String reverseVowels(String s) {
3        if (s.length() == 1) {
4            return s;
5        }
6        int n = s.length();
7        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
8        char[] chars = s.toCharArray();
9        int i = 0;
10        int j = n-1;
11        while (i < j) {
12            char l = chars[i];
13            char r = chars[j];
14            if (set.contains(l) && set.contains(r)) {
15                char temp = chars[i];
16                chars[i] = chars[j];
17                chars[j] = temp;
18                i++;
19                j--;
20            } else if (set.contains(l)) {
21                j--;
22
23            } else if (set.contains(r)) {
24                i++;
25
26            } else {
27                i++;
28                j--;
29            }
30        }
31        String res = new String(chars);
32        return res;
33       
34
35
36    }
37}