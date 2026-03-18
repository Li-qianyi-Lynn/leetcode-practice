1class KthLargest {
2    PriorityQueue<Integer> pq;
3    int k;
4
5    public KthLargest(int k, int[] nums) {
6        this.k = k;
7        pq = new PriorityQueue<>();
8        for (int num : nums) {
9            pq.add(num);    
10        }
11        while (k < pq.size()) {
12            pq.poll();
13        }
14
15    
16    }
17    
18    public int add(int val) {
19        pq.add(val);
20        if (k < pq.size()) {
21            pq.poll();
22        }
23        return pq.peek();
24        
25    }
26}
27
28/**
29 * Your KthLargest object will be instantiated and called as such:
30 * KthLargest obj = new KthLargest(k, nums);
31 * int param_1 = obj.add(val);
32 */