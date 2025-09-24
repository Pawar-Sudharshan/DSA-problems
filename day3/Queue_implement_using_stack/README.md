# Day 3: Implement Queue using Stack

## Problem Statement
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:
- `void push(int x)` Pushes element x to the back of queue.
- `int pop()` Removes the element from in front of queue and returns that element.
- `int peek()` Returns the element at the front of the queue.
- `boolean empty()` Returns true if the queue is empty, false otherwise.

**Notes:**
- You must use only standard operations of a stack -- which means only `push to top`, `peek/pop from top`, `size`, and `is empty` operations are valid.
- Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue), as long as you use only a stack's standard operations.

**Constraints:**
- 1 ≤ x ≤ 9
- At most 100 calls will be made to push, pop, peek, and empty.
- All the calls to pop and peek are valid.

**Follow up:** Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

## Approach

### Two Stack Technique

The key insight is to use two stacks to simulate the FIFO behavior of a queue:

1. **Stack 1 (s1):** Used for pushing new elements (acts as input stack)
2. **Stack 2 (s2):** Used for popping elements (acts as output stack)

**Algorithm:**
1. **Push Operation:** Always push to s1
2. **Pop/Peek Operations:** 
   - If s2 is not empty, pop/peek from s2
   - If s2 is empty, transfer all elements from s1 to s2, then pop/peek from s2
3. **Empty Operation:** Check if both stacks are empty

**Time Complexity:** 
- Push: O(1)
- Pop/Peek: Amortized O(1), worst case O(n)
- Empty: O(1)

**Space Complexity:** O(n) where n is the number of elements in the queue

## Code Implementation

```java
import java.util.*;

class MyQueue {
    Stack<Integer> s1 , s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
      return  s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
      return  s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek()); // returns 1
        System.out.println(obj.pop());  // returns 1
        System.out.println(obj.empty()); // returns false
    }
}
```

## Dry Run Examples

### Example 1: Basic Operations
**Operations:** ["MyQueue", "push", "push", "peek", "pop", "empty"]
**Parameters:** [[], [1], [2], [], [], []]

#### Step-by-step Execution:

| Operation | Action | s1 | s2 | Result |
|-----------|--------|----|----|--------|
| MyQueue() | Initialize | [] | [] | - |
| push(1) | Push 1 to s1 | [1] | [] | - |
| push(2) | Push 2 to s1 | [1,2] | [] | - |
| peek() | s2 empty, transfer from s1 to s2 | [] | [2,1] | 1 |
| pop() | Pop from s2 | [] | [2] | 1 |
| empty() | Check both stacks | [] | [2] | false |

**Expected Output:** [null, null, null, 1, 1, false]

---

### Example 2: Multiple Push and Pop Sequence
**Operations:** ["push", "push", "push", "pop", "push", "pop", "pop", "pop"]
**Parameters:** [[1], [2], [3], [], [4], [], [], []]

#### Step-by-step Execution:

| Operation | Action | s1 | s2 | Result |
|-----------|--------|----|----|--------|
| push(1) | Push 1 to s1 | [1] | [] | - |
| push(2) | Push 2 to s1 | [1,2] | [] | - |
| push(3) | Push 3 to s1 | [1,2,3] | [] | - |
| pop() | s2 empty, transfer s1→s2, then pop | [] | [3,2] | 1 |
| push(4) | Push 4 to s1 | [4] | [3,2] | - |
| pop() | Pop from s2 (no transfer needed) | [4] | [3] | 2 |
| pop() | Pop from s2 (no transfer needed) | [4] | [] | 3 |
| pop() | s2 empty, transfer s1→s2, then pop | [] | [] | 4 |

**Expected Output:** [-, -, -, 1, -, 2, 3, 4]

## Stack Data Flow Diagram

```
Initial State:
s1: []
s2: []

After push(1), push(2), push(3):
s1: [1, 2, 3] ← top
s2: []

During first pop() - Transfer from s1 to s2:
s1: [] 
s2: [3, 2, 1] ← top
     ↑
     │
     └── pop() returns 1

After push(4):
s1: [4] ← top
s2: [3, 2] ← top

Next pop() operations use s2 until empty:
s2: [3, 2] → pop() returns 2 → s2: [3]
s2: [3] → pop() returns 3 → s2: []

When s2 becomes empty again, transfer s1 to s2:
s1: [4] → s2: [4] → pop() returns 4
```

### Visual Representation of Stack Operations:

```
PUSH Operation:
┌─────────┐    ┌─────────┐
│   s1    │    │   s2    │
├─────────┤    ├─────────┤
│  new    │←── │         │
│ element │    │         │
│   ...   │    │         │
└─────────┘    └─────────┘

POP/PEEK Operation (when s2 is empty):
┌─────────┐    ┌─────────┐
│   s1    │    │   s2    │
├─────────┤    ├─────────┤
│         │──→ │ oldest  │←── pop/peek
│         │    │   ...   │
│         │    │ newest  │
└─────────┘    └─────────┘
```

## Key Insights

1. **Amortized Analysis:** While a single pop() operation might take O(n) time in the worst case (when transferring all elements), the amortized time complexity is O(1) because each element is transferred at most once.

2. **FIFO Guarantee:** The two-stack approach ensures that the first element pushed is the first one to be popped, maintaining the queue's FIFO property.

3. **Lazy Transfer:** Elements are only transferred from s1 to s2 when s2 is empty and a pop/peek operation is requested, making the solution efficient.

4. **Space Efficiency:** Uses only two stacks without any additional data structures.

## Complexity Analysis

- **Time Complexity:** 
  - Push: O(1) - Always constant time
  - Pop/Peek: Amortized O(1) - Each element is moved at most once
  - Empty: O(1) - Simple boolean check

- **Space Complexity:** O(n) - Where n is the maximum number of elements in the queue

- **Optimal Solution:** Yes, this achieves the follow-up requirement of amortized O(1) operations
