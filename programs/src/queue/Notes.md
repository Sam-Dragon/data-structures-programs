# Queue

> Definition

- It is the linear data structure while is used for storing the elements
- It works on the principle of FIFO [First In First Out] or LILO [Last In Last Out]

> Operations

- It performs operations like
    - enqueue(element) - inserting element into list
    - dequeue() - deleting element from list
    - peek() - shows the top element in the list
    - size() - shows the number of elements in the list
    - empty() - check if stack any elements
    - display() - display the contents of the list

> Use cases

- Bank Queue
- Ticket Booking Queue

> Limitations

- Once the deletion is performed, even if the queue gets empty, we cannot perform insertion again in simple queue
- We can fetch middle of the element in stack

> Complexity

- Space - O(1)
- Time - O(1)

> Implementation

- Array
- LinkedList [Recommended]

> Points to Remember

- We can implement queue using single pointer but if we use two pointer, insertion becomes
  faster [Additional memory is allocated]

> Trick Points

- stack is designed to work in sequential order
- Most queue questions will require 2 queues for implementation