1class Solution {
2    public int minMutation(String startGene, String endGene, String[] bank) {
3        Set<String> set = new HashSet<>(Arrays.asList(bank));
4        // edge case
5        if (!set.contains(endGene)) {
6            return -1;
7
8        }
9        Set<String> seen = new HashSet<>();
10        Deque<String> dq = new ArrayDeque<>();
11        int steps = 0; // level
12
13        dq.offerLast(startGene);
14        seen.add(startGene);
15        
16        while (!dq.isEmpty()) {
17            int size = dq.size();
18            for (int i = 0; i < size; i++) {
19                String poll = dq.pollFirst();
20                if (poll.equals(endGene)) {
21                    return steps; // 找到就返回了
22
23                }
24
25                for (int j = 0; j < 8; j++) {
26                    for (char c : new char[]{'A', 'C', 'G', 'T'}) {
27                        String cur = poll.substring(0,j) + c + poll.substring(j+1);
28                        if (!seen.contains(cur) && set.contains(cur)) {
29                            dq.offerLast(cur);
30                            seen.add(cur); // 加进去
31                        }
32                    }
33                }
34
35            }
36            steps++;
37
38        }
39        return -1;
40        
41    }
42}