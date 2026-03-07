1class MinStack {
2    Deque<Integer> dq;
3    Deque<Integer> mindq;
4
5    public MinStack() {
6        dq = new ArrayDeque<>();
7        mindq = new ArrayDeque<>();
8        
9    }
10    
11    public void push(int val) {
12        dq.offerLast(val);
13        if (mindq.isEmpty() || val <= mindq.peekLast()) {
14            mindq.offerLast(val);
15
16        }  
17    }
18    
19    public void pop() {
20        int poll = dq.pollLast();
21        if (mindq.peekLast() == poll) {
22            mindq.pollLast();
23        }
24        
25    }
26    
27    public int top() {
28        return dq.peekLast();
29        
30    }
31    
32    public int getMin() {
33        return mindq.peekLast();
34        
35    }
36}
37
38/**
39 * Your MinStack object will be instantiated and called as such:
40 * MinStack obj = new MinStack();
41 * obj.push(val);
42 * obj.pop();
43 * int param_3 = obj.top();
44 * int param_4 = obj.getMin();
45 */