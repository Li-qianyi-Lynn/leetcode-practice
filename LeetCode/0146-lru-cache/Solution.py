class Node:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {} # key ->node
        self.head = Node(0,0)
        self.tail = Node(0,0)
        self.head.next = self.tail
        self.tail.prev = self.head

        
    def get(self, key: int) -> int:
        if key in self.cache:
            cur_node = self.cache[key]
            self.detach(cur_node)
            self.add_to_end(cur_node)
            return cur_node.val
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            cur_node = self.cache[key]
            self.detach(cur_node)
            self.add_to_end(cur_node)
            cur_node.val = value
        else:
            if len(self.cache) >= self.capacity:
                to_remove_node = self.head.next
                self.detach(to_remove_node)
                del self.cache[to_remove_node.key]
            
            new_node = Node(key,value)
            self.add_to_end(new_node)
            self.cache[key] = new_node
                


    
    def add_to_end(self, node) -> None: # latest used 
        bef_tail = self.tail.prev
        bef_tail.next = node
        node.next = self.tail
        node.prev = bef_tail
        self.tail.prev = node
        

    def detach(self, node) -> None:
        pre_node = node.prev
        aft_node = node.next
        pre_node.next = aft_node
        aft_node.prev = pre_node

# head -> node1 -> node2 -> tail

# node3
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)