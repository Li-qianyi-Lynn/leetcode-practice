1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        if (numCourses == 1 || prerequisites.length == 0) {
4            return true;
5
6        }
7
8        int finished = 0;
9        HashMap<Integer, List<Integer>> map = new HashMap<>();
10        int[] indegree = new int[numCourses];
11        for (int[] pres : prerequisites) {
12            int pre = pres[1];
13            int course = pres[0];
14            indegree[course]++;
15            map.putIfAbsent(pre,new ArrayList<>());
16            map.get(pre).add(course);
17
18        }
19
20        Deque<Integer> dq = new ArrayDeque<>();
21        for (int i = 0; i < numCourses; i++) {
22            if (indegree[i] == 0) {
23                dq.offerLast(i);
24                finished++;
25            }
26        }
27
28        while (!dq.isEmpty()) {
29            int cur = dq.pollFirst();
30            List<Integer> courses = map.get(cur);
31            if (courses == null) {
32                continue;
33
34            }
35            for (int i = 0; i < courses.size(); i++) {
36                int c = courses.get(i);
37                indegree[c]--;
38                if (indegree[c] == 0) {
39                    finished++;
40                    dq.offerLast(c);
41                }
42            }
43        }
44
45        return finished == numCourses;
46  
47
48        
49    }
50}
51
52/**
53
54dependency problem
55
56bfs
57
58indegree map: int[] to store each course has how many pres
59
60int finished course
61hashmap pre: course
62
63bfs:
64use deque to store finished courses and update courses num
65
66
67
68compare finished course num with numCourses
69
70
71 */