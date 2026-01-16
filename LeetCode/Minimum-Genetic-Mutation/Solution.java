1class Solution {
2    public int minMutation(String startGene, String endGene, String[] bank) {
3        Set<String> set = new HashSet<>(Arrays.asList(bank));
4
5        // edge case
6        if (!set.contains(endGene)) {
7            return -1;
8        }
9
10        Deque<String> dq = new ArrayDeque<>();
11        Set<String> seen = new HashSet<>();
12        int steps = 0;
13
14        dq.offerLast(startGene);
15        seen.add(startGene);
16
17        while (!dq.isEmpty()) {
18            int size = dq.size();
19
20            for (int i = 0; i < size;i++) {
21                String poll = dq.pollFirst();
22                if (poll.equals(endGene)) {
23                    return steps;
24                }
25                // iterate poll string. change one char 
26                for (int j = 0; j < 8; j++) {
27                    for (char c : new char[]{'A', 'C', 'G', 'T'}) {
28                        String cur = poll.substring(0,j) + c + poll.substring(j+1);
29                // check if in the bank && if in the seen set
30                        if (set.contains(cur) && !seen.contains(cur)) {
31                            dq.offerLast(cur);
32                            seen.add(cur);
33                        }
34                    }
35                }
36            }
37            steps++;
38
39        }
40        return -1;
41        
42    }
43}
44/**
45change one letter from 'A', 'C', 'G', and 'T'
46shortest pathway problems - bfs
47
48edge case
49endgene must be in the bank
50
51
52deque
53set[] seen 
54step // level
55
56two for loops to check the gene string[],each time i with change one char into one of 'A', 'C', 'G', and 'T', and rebuilt a new string,
57check if the new string is the end, if end, i can just return the step;
58check if in the bank && if in the seen set
59
60-yes, add it to the deque; add it to the seen set[]
61
62
63
64return -1;
65
66
67 */