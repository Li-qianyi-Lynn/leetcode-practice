def middleNode(head):
  depth = 1
  nodes = {}
  while head: 
    nodes[depth] = head.val
    head = head.next
    depth += 1

  return nodes[(depth//2) + 1] if depth%2 else nodes[(depth//2)]