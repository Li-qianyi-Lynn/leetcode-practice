1class Solution {
2    public int compress(char[] chars) {
3        // pruning
4        if (chars.length == 1) {
5            return 1;
6        }
7
8        int n = chars.length;
9        int s = 0;
10        int f = 0;
11        int cur = 0;
12        while (f < n) {
13            int count = 0;
14            
15            // len
16            while (f < n && chars[f] == chars[s]) {
17                f++;
18                count++;
19            }
20            
21            chars[cur++] = chars[s];
22            // ? mark start index?
23            int start = cur;
24            if (count > 1) {
25                while (count != 0) { 
26                    chars[cur++] = (char)((count % 10) + '0');
27                    count = count / 10;
28                }
29                reverse(chars, start, cur-1);
30            }
31
32            s = f;
33
34        }
35        return cur;    
36    }
37
38    private void reverse (char[] chars, int start, int end) {
39        while (start < end) {
40            char temp = chars[start];
41            chars[start] = chars[end];
42            chars[end] = temp;
43            start ++;
44            end --;
45        }
46    }
47}
48/**
49group len 
50- 1 append char
51- > 1 append char, len
52
5310 -> 1 0
54
55modify chars[]
56 
57 ["a","a","b","b","c","c","c"]
58           s
59           f
6012345
61  cur 
62 1. len (same chars) : while 
63 2. 1) how to write the ans -> 
64    2) 12 -> ?  count % 10  = 2 count / 10 1 -> reverse 
65 */