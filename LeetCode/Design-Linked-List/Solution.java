        public Node(int x)
        {
            val = x;
        }
    }

    /** Initialize your data structure here. */
    int size;
    Node head;

    public MyLinkedList()
    {
        size = 0;
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int Get(int index)
    {
        if (index < 0 || index >= size)
            return -1;

        Node currIndex = head;
        for (int i = 0; i < index; i++) currIndex = currIndex.next;

        return currIndex.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void AddAtHead(int val)
    {
        Node newNode = new Node(val);
        if (head == null)
        {
            head = newNode;
            newNode.next = null;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void AddAtTail(int val)
    {
        Node newNode = new Node(val);
        if (head == null) { 
            AddAtHead(val);
            return;
        }
        else
        {
            Node currNode = head;
            for (int i = 0; i < size-1; i++)
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.next = null;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void AddAtIndex(int index, int val)
    {
        if (index > size) return;
        else if (index == size)
        {
            AddAtTail(val);
            return;
        }else if (index == 0)
        {
            AddAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node currNode = head;
        for (int i = 0; i < index - 1; i++) currNode = currNode.next;

        newNode.next = currNode.next;
        currNode.next = newNode;

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void DeleteAtIndex(int index)
    {
        if (index < 0 || index >= size) return;
        else if(index==0)
        {
            head = head.next;
            size--;
        }
        else
        {
            Node currNode = head;
            for (int i = 0; i < index - 1; i++) currNode = currNode.next;

            currNode.next = currNode.next.next;
            size--;
        }
    }

    public static void Main(string[] args)
    {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.AddAtHead(1); //linkedList = 1
        linkedList.AddAtHead(2); //linkedList = 2->1
        linkedList.AddAtTail(3); //linkedList = 2->1->3
        linkedList.AddAtTail(4); //linkedList = 2->1->3->4
        Console.WriteLine("Value at index 1 is: {0}",linkedList.Get(1)); //1
        Console.WriteLine("Value at index 0 is: {0}", linkedList.Get(0)); //2
        linkedList.AddAtIndex(3, 10); //linkedList = 2->1->3->10->4
        linkedList.AddAtIndex(0, 1); //linkedList = 1->2->1->3->10->4
        linkedList.DeleteAtIndex(0); //linkedList = 2->1->3->10->4
        linkedList.DeleteAtIndex(4); //linkedList = 2->1->3->10
        linkedList.DeleteAtIndex(2); //linkedList = 2->1->10

        Node printValue = linkedList.head;
        Console.WriteLine("Values inside LinkedList");
        for (int i=0; i< linkedList.size; i++)
        {
            Console.Write(printValue.val + " ");
            printValue = printValue.next;
        }

        Console.ReadLine();
    }
}