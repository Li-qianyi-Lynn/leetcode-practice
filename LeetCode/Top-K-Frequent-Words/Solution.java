    
    //  O(N*log(N))
    priority_queue<int> p;
    for(auto x : arr) p.push(x);

    // O(N)
    priority_queue<int> p(arr.begin(), arr.end());
    // It uses Floyds heapify algorithm