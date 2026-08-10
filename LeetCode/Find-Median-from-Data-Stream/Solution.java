1class MedianFinder {
2    // pq
3    /**
4    minPQ -> large
5    maxPq -> small 
6    minPq size > maxpq -> pop
7    
8    */
9    PriorityQueue<Integer> minpq; // 3
10    PriorityQueue<Integer> maxpq; // 1 2
11
12
13    public MedianFinder() {
14        minpq = new PriorityQueue<>();
15        maxpq = new PriorityQueue<>((a,b) -> b - a);
16        
17    }
18    
19    public void addNum(int num) {
20        maxpq.offer(num);
21        minpq.offer(maxpq.poll()); //!!!!
22
23        if (minpq.size() > maxpq.size()+1) {
24            int cur = minpq.poll(); //todo
25            maxpq.offer(cur);
26        }
27        // for (int i = 0; i < minpq.size(); i++) {
28        //     System.out.println(minpq.get(i));
29
30        // }
31
32        // for (int i = 0; i < maxpq.size(); i++) {
33        //     System.out.println(maxpq.get(i));
34
35        // }
36
37
38        
39    }
40    
41    public double findMedian() {
42        double res = 0.0;
43        if (minpq.size() == maxpq.size()) {
44            res = ((double)minpq.peek() + maxpq.peek()) / 2.0;
45        } else {
46            res = minpq.peek();
47        }
48        return res;
49        
50    }
51}
52
53/**
54 * Your MedianFinder object will be instantiated and called as such:
55 * MedianFinder obj = new MedianFinder();
56 * obj.addNum(num);
57 * double param_2 = obj.findMedian();
58 */
59
60