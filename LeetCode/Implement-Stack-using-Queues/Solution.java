    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int theTop = top;
        while(queue.size() > 1) {
            top = queue.remove();
            queue2.add(top);   
        }
        queue.remove();
        Queue<Integer> temp = queue;
        queue = queue2;
        queue2 = temp;
        return theTop;
    }