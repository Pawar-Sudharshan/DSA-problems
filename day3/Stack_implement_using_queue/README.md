# Day 3: Implement Stack using Queue

## Problem Statement
Implement a stack using only queue operations. The stack should support:
- `void push(int x)` - Push element x onto stack
- `int pop()` - Remove and return the element on top of the stack
- `int top()` - Return the element on top of the stack
- `boolean empty()` - Return true if the stack is empty

## Approach
This implementation uses the **two-queue approach** to simulate stack behavior:

1. **Data Structure**: Use two queues (`q1` and `q2`)
2. **Push Operation**: 
   - Add new element to `q2`
   - Transfer all elements from `q1` to `q2`
   - Swap the references of `q1` and `q2`
3. **Pop Operation**: Simply poll from `q1`
4. **Top Operation**: Simply peek from `q1`
5. **Empty Operation**: Check if `q1` is empty

## Algorithm Logic

### Push Operation:
1. Enqueue new element to `q2`
2. While `q1` is not empty, dequeue from `q1` and enqueue to `q2`
3. Swap `q1` and `q2` references

### Pop/Top/Empty Operations:
- These operations directly use `q1` since it maintains stack order

## Code Implementation

```java
import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
```

## Dry Run Example

Let's trace through operations: `push(1)`, `push(2)`, `push(3)`, `pop()`, `top()`

### Initial State:
| q1 | q2 |
|----|----| 
| [] | [] |

### After push(1):
1. `q2.offer(1)` → q2 = [1]
2. q1 is empty, no transfer needed
3. Swap: q1 = [1], q2 = []

| q1 | q2 |
|----|----| 
| [1] | [] |

### After push(2):
1. `q2.offer(2)` → q2 = [2]
2. Transfer from q1 to q2: q2 = [2, 1]
3. Swap: q1 = [2, 1], q2 = []

| q1 | q2 |
|----|----| 
| [2, 1] | [] |

### After push(3):
1. `q2.offer(3)` → q2 = [3]
2. Transfer from q1 to q2: q2 = [3, 2, 1]
3. Swap: q1 = [3, 2, 1], q2 = []

| q1 | q2 |
|----|----| 
| [3, 2, 1] | [] |

### After pop():
- `q1.poll()` returns 3
- q1 = [2, 1]

| q1 | q2 |
|----|----| 
| [2, 1] | [] |

### After top():
- `q1.peek()` returns 2 (no modification)

| q1 | q2 |
|----|----| 
| [2, 1] | [] |

## Data Flow Diagram

```
Push Operation:
┌─────────┐    ┌─────────┐
│   q1    │    │   q2    │
│ [a,b,c] │    │   [x]   │ ← New element x added
└─────────┘    └─────────┘
     │              ↑
     │ Transfer all │
     └──────────────┘

After Transfer & Swap:
┌─────────┐    ┌─────────┐
│   q1    │    │   q2    │
│[x,a,b,c]│    │   []    │ ← Stack order maintained
└─────────┘    └─────────┘
```

## Complexity Analysis

### Time Complexity:
- **Push**: O(n) - where n is the number of elements in the stack
  - Need to transfer all elements from q1 to q2
- **Pop**: O(1) - direct queue operation
- **Top**: O(1) - direct queue operation  
- **Empty**: O(1) - direct queue operation

### Space Complexity:
- **Overall**: O(n) - where n is the number of elements stored
- Uses two queues but total space is still O(n) as elements are not duplicated

## Key Insights:
1. The two-queue approach maintains LIFO order by reorganizing elements on each push
2. Push operation is expensive (O(n)) but other operations are efficient (O(1))
3. Alternative single-queue approach exists but requires more complex logic
4. This demonstrates how different data structures can simulate each other's behavior
