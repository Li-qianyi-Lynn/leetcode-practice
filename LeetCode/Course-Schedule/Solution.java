1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        if (prerequisites.length == 0) {
4            return true;       
5        }
6        int finished = 0;
7        Map<Integer, List<Integer>> map = new HashMap<>();
8        
9        int[] indegree = new int[numCourses];
10        for (int[] pres : prerequisites) {
11            int pre = pres[1];
12            int course = pres[0];   
13            indegree[course]++;
14            map.putIfAbsent(pre, new ArrayList<>());
15            map.get(pre).add(course);
16        }
17        
18        Deque<Integer> dq = new ArrayDeque<>();
19        for (int i = 0; i < numCourses; i++) {
20            if (indegree[i] == 0) {
21                dq.offerLast(i);  
22                finished++;
23            }  
24        }
25        while (!dq.isEmpty()) {
26            int poll = dq.pollFirst();
27            List<Integer> unlockedCourses = map.get(poll);
28            if (unlockedCourses == null) {
29                continue;
30                
31            }
32            for (int i = 0; i < unlockedCourses.size(); i++) {
33                int c = unlockedCourses.get(i);
34                indegree[c]--;
35                if (indegree[c]== 0) {
36                    dq.offerLast(c);   
37                    finished++;
38                }   
39            }   
40        }
41        return finished == numCourses;
42        
43    }
44}
45/**
46dependency 
47bfs
481. map: pre -> unlocked courses
492. int[] : each course has how many precourses
50
51bfs
52put unlocked courses(arr[course] == 0) to the deque
53
54check numCourses and unlocked courses
55
56
57
58 */