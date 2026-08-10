1class MedianFinder {
2    PriorityQueue<Integer> minHeap;
3    PriorityQueue<Integer> maxHeap;
4
5    public MedianFinder() {
6        minHeap = new PriorityQueue<>();
7        maxHeap = new PriorityQueue<>((a,b) -> b - a);
8
9    }
10    
11    public void addNum(int num) {
12        maxHeap.offer(num);
13        minHeap.offer(maxHeap.poll());// 始终保持minHeap >= maxHeap
14        if (minHeap.size() > maxHeap.size()+1) {
15            int poll = minHeap.poll();
16            maxHeap.offer(poll);
17        }
18    
19
20    }
21    
22    public double findMedian() {
23        double res = 0.0;
24        if (minHeap.size()!= maxHeap.size()) {
25            res = minHeap.peek() * 1.0;
26    
27        } else {
28            res = ((long)minHeap.peek() + maxHeap.peek()) / 2.0; // There's a potential integer overflow risk here. If both values are very large, their sum might exceed Integer.MAX_VALUE before being divided by 2
29
30        }
31        return res;
32        
33    }
34}
35
36/**
37 * Your MedianFinder object will be instantiated and called as such:
38 * MedianFinder obj = new MedianFinder();
39 * obj.addNum(num);
40 * double param_2 = obj.findMedian();
41 */
42
43 /**
44 
45 maxHeap: 2 1 0 -1 -2 -3 -4 -5
46 minHeap: 3  4  5  6  7  8  9 
47 
48 -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9
49 
50 all int in minHeap > maxHeap
51 size 不要差太大
52
53 比较size 
54 如果 == peak1 + peak2 / 2.0
55 or minHeap.peak()
56  */