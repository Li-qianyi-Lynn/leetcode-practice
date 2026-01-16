1class Solution {
2    public int minMutation(String start, String end, String[] bank) {
3        
4        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
5        
6        //edge case
7        if (!bankSet.contains(end)) {
8            return -1;
9
10        }
11        // First, I convert the bank array into a HashSet. This allows for $O(1)$ constant time lookups. I also check if the end gene is even in the bank; if not, it’s impossible to reach, so I return -1 immediately.
12
13        Deque<String> dq = new ArrayDeque<>();
14        Set<String> seen = new HashSet<>();
15        dq.offerLast(start);
16        seen.add(start);
17
18        int steps = 0;
19        
20        while (!dq.isEmpty()) {
21            int nodesInQueue = dq.size();
22            for (int j = 0; j < nodesInQueue; j++) {
23                String node = dq.pollFirst();
24                if (node.equals(end)) {
25                    return steps;
26                }
27
28                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
29                    for (int i = 0; i < node.length(); i++) {
30                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
31                        if (!seen.contains(neighbor) && bankSet.contains(neighbor)) {
32                            dq.offerLast(neighbor);
33                            seen.add(neighbor);
34                        }
35                    }
36                }
37            }
38            // I process the queue level-by-level. For each gene string, I explore its neighbors by: Iterating through each of the 8 character positions. Replacing the character with the four possible bases: 'A', 'C', 'G', and 'T'.If a mutation is in the bank and hasn't been seen yet, I add it to the queue for the next level."
39            
40            steps++;
41        }
42        
43        return -1;
44    }
45}
46
47/**
48
49Shortest Path problem in a graph.
50 */