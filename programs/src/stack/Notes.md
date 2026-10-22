# Stack

> Definition

- It is the linear data structure while is used for storing the elements
- It works on the principle of LIFO [Last In First Out] or FILO [First In Last Out]
- It is useful when you work with **HISTORY** of data
- stack is designed to work in **REVERSED** order
- Most stack questions will require 2 stacks for implementation

> Operations

- It performs operations like
    - push(element) - inserting element into list
    - pop() - deleting element from list
    - peek() - shows the top element in the list
    - size() - shows the number of elements in the list
    - empty() - check if stack any elements
    - display() - display the contents of the list

> Use cases

- Balancing of Symbols
- Method calls
- **Recursion**
- Exceptions callback
- Infix to postfix expression,
- Evaluation of postfix expression,
- Tower of Hanoi
- Object creation and destruction
- Find the spans [Stock Market Spans]
- Page visit in browsers
- Undo Sequence in editor
- Matching Tags in HTML & XML
- **Indirect Uses**: It is used in Trees [BFS]

> Limitations

- Once the deletion is performed, if the stack is empty, it will throw underflow exception
- Once the insertion is performed, if the stack is full, it will throw overflow exception
- We can fetch middle of the element in stack

> Complexity

- Space - O(1)
- Time - O(1)

> Implementation

- Array
- LinkedList [Recommended]