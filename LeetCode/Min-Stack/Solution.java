1class MinStack {
2
3    Deque<Integer> minStack;
4    Deque<Integer> stack;
5
6    public MinStack() {
7        minStack = new ArrayDeque<>();
8        stack = new ArrayDeque<>();     
9    }
10    
11    public void push(int value) {
12        if (minStack.isEmpty()) {
13            minStack.offerLast(value);
14        } else {
15            if (value <= minStack.peekLast()) {
16                minStack.offerLast(value);
17            }   
18        }
19
20        stack.offerLast(value);   
21    }
22    
23    public void pop() {
24        int temp = stack.pollLast();
25        if (minStack.peekLast() == temp) {
26            minStack.pollLast();
27        }    
28    }
29    
30    public int top() {   
31        return stack.peekLast();      
32    }
33    
34    public int getMin() {
35        return minStack.peekLast();    
36    }
37}
38
39/**
40 * Your MinStack object will be instantiated and called as such:
41 * MinStack obj = new MinStack();
42 * obj.push(value);
43 * obj.pop();
44 * int param_3 = obj.top();
45 * int param_4 = obj.getMin();
46 *//** 3 1
47 
48 minstack
49 2 1 
50 
51 stack
52 2 3 1
53 
54
55 
56  */