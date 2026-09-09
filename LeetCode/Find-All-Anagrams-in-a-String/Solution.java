1class Solution {
2    public List<Integer> findAnagrams(String s, String p) {
3        int[] window = new int[26]; // keep k 
4        int[] target = new int[26];
5
6        // init target
7        for (char c : p.toCharArray()) {
8            target[c - 'a']++;
9
10        }
11        int k = p.length();
12        int n = s.length();
13        List<Integer> res = new ArrayList<>();
14        // int l = r -k+1;
15
16        // sliding window
17        for (int r = 0; r < n; r++) {
18            //add r to the window
19            char c = s.charAt(r);
20            window[c-'a']++;
21            // if length > k ,remove l in the window
22            if (r >= k) {
23                char leftChar = s.charAt(r-k);
24                window[leftChar - 'a']--;
25            }
26
27            // check freq and char
28            if (r >= k-1 && Arrays.equals(window, target)) {
29                res.add(r-k+1);
30
31            }
32
33        }
34        return res;
35
36        
37        
38    }
39}
40/**
41k 
42
43
44 */