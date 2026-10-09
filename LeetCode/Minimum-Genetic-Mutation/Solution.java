1class Solution {
2    public int minMutation(String startGene, String endGene, String[] bank) {
3        Set<String> set = new HashSet<>(Arrays.asList(bank));
4        if (!set.contains(endGene)) {
5            return -1;
6
7        }
8        char[] chars = new char[]{'A', 'C', 'G', 'T'};
9        Set<String> visited = new HashSet<>();
10        Deque<String> dq = new ArrayDeque<>();
11        dq.offer(startGene);
12        visited.add(startGene);
13        int res = 0;
14        while (!dq.isEmpty()) {
15            int size = dq.size();
16
17            for (int i = 0; i < size; i++) {
18                String poll = dq.pollFirst();
19                if (poll.equals(endGene)) {
20                    return res;
21
22                }
23
24                for (int j= 0; j < poll.length(); j++) {
25                    for (char c : chars) {
26                        String next = poll.substring(0,j) + c + poll.substring(j+1,8);
27
28                        if (set.contains(next) && !visited.contains(next)) {
29                            dq.offerLast(next);
30                            visited.add(next);
31
32                        }
33
34                    }
35                }
36
37            }
38            res++;
39
40        }
41        return -1;
42        
43    }
44}