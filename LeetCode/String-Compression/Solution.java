1class Solution {
2    public int compress(char[] chars) {
3        if (chars.length == 1) {
4            return 1;
5        }
6        int n =chars.length;
7        int slow = 0;
8        int fast = 0;
9        int cur = 0;
10        while (fast < n) {
11            // cur = slow;
12            while (fast < n && chars[fast] == chars[slow]) {
13                fast++;
14            }
15            int count = fast - slow;
16            // write char
17            chars[cur++] = chars[slow];
18
19            if (count > 1) {
20                // String s = String.valueOf(count);
21                // char[] temp = s.toCharArray();
22                // for (char c : temp) {
23                //     chars[cur++] = c;
24                // }
25                for (char c : String.valueOf(count).toCharArray()) {
26                    chars[cur++] = c;
27                }
28
29            }
30            slow = fast;
31
32        }
33        return cur;
34         
35        
36    }
37}
38/**
39
40["a","a","b","b","c","c","c"]
41  s
42          f
43 base
44
451. how many letters 
462. write: chars[base++]=chars[s]
473. if count > 1: digits -> string -> tochararray
48chars[base++]= c;
49
50
51s = f
52
53return base
54
55
56
57
58
59
60 */