class DLinkedNode:
    def __init__(self, key = 0, val = 0):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None
class LRUCache:


    def __init__(self, capacity: int):
        self.capacity = capacity # key -> DLinkedNode
        self.cache = {}
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        
    def detach(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
    
    def move_to_end(self, node):
        pre_tail = self.tail.prev
        self.tail.prev = node
        node.next = self.tail
        pre_tail.next = node
        node.prev = pre_tail



    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.detach(node)
            self.move_to_end(node)
            return node.val
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.val = value
            self.detach(node)
            self.move_to_end(node)
        else:
            node = DLinkedNode(key,value)
            if len(self.cache) >= self.capacity:
                node_to_remove = self.head.next
                self.detach(node_to_remove)
                self.cache.pop(node_to_remove.key)
            
            self.move_to_end(node)
            self.cache[key] = node


        
# head node1 node2 node3 tail

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)