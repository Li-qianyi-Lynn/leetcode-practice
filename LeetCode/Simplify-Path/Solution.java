1class Solution {
2    public String simplifyPath(String path) {
3        String[] clean = path.split("/");
4        StringBuilder sb = new StringBuilder();
5        Deque<String> dq = new ArrayDeque<>();
6        for (String s : clean) {
7            if (s.equals("") || s.equals(".")) {
8                continue;
9
10            } else if (s.equals("..")) {
11                if (!dq.isEmpty()) {
12                    dq.pollLast();
13                }
14
15            } else {
16                dq.offerLast(s);
17            }
18        }
19        if (dq.isEmpty()) {
20            return "/";
21
22        }
23        while (!dq.isEmpty()) {
24            sb.append("/").append(dq.pollFirst());
25
26        } 
27        return sb.toString();
28        
29    }
30}
31/**
32stack: container
33
34iteration:
35/: normal (tailing ?)
36.: normal
37..: pollLast
38//: offer /
39others: offerLast
40
41size >= 2 , last == / last/ not added to sb
42
43
44
45 */