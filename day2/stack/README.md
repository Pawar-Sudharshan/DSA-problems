# Stack Implementation - Day 2

## Problem Statement
Implement a stack data structure using arrays with the following operations:
- `push(x)`: Insert element x to the top of the stack
- `pop()`: Remove and return the top element from the stack
- `peek()` or `top()`: Return the top element without removing it
- `isEmpty()`: Check if the stack is empty
- `size()`: Return the current size of the stack

## Constraints
- Stack should handle integer values
- Maximum capacity should be defined
- Handle overflow and underflow conditions
- Operations should be efficient

## Approach
We implement a stack using an array-based approach where:
1. Use an array to store stack elements
2. Maintain a `top` pointer to track the current top element
3. Initialize `top` to -1 for an empty stack
4. For push operation: increment top and add element
5. For pop operation: return element at top and decrement top
6. Check bounds for overflow and underflow conditions

## Code Implementation (Java)

```java
class Stack {
    private int[] arr;
    private int top;
    private int capacity;
    
    // Constructor to initialize stack
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    // Push operation
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
        System.out.println(x + " pushed to stack");
    }
    
    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
    
    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    // Get current size
    public int size() {
        return top + 1;
    }
    
    // Display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```

## Dry Run Examples

### Example 1: Basic Operations
```
Initial: Stack(5) -> top = -1, arr = [_, _, _, _, _]

push(10): top = 0, arr = [10, _, _, _, _]
push(20): top = 1, arr = [10, 20, _, _, _]
push(30): top = 2, arr = [10, 20, 30, _, _]

peek(): returns 30 (top element)
size(): returns 3

pop(): returns 30, top = 1, arr = [10, 20, _, _, _]
pop(): returns 20, top = 0, arr = [10, _, _, _, _]

peek(): returns 10
isEmpty(): returns false

pop(): returns 10, top = -1, arr = [_, _, _, _, _]
isEmpty(): returns true
```

### Example 2: Overflow/Underflow Handling
```
Stack(2) -> capacity = 2

push(1): Success -> [1, _]
push(2): Success -> [1, 2]
push(3): "Stack Overflow" (capacity exceeded)

pop(): returns 2 -> [1, _]
pop(): returns 1 -> [_, _]
pop(): "Stack Underflow" (empty stack)
```

## Key Insights

1. **LIFO Principle**: Stack follows Last In, First Out principle
2. **Array Implementation**: Simple and efficient with O(1) operations
3. **Top Pointer**: Critical for tracking the current top element
4. **Boundary Conditions**: Always check for overflow and underflow
5. **Memory Efficiency**: Fixed size array provides predictable memory usage
6. **Initialization**: top = -1 indicates empty stack
7. **Real Applications**: Function calls, expression evaluation, undo operations

## Complexity Analysis

### Time Complexity
- **Push Operation**: O(1) - Direct array access
- **Pop Operation**: O(1) - Direct array access
- **Peek Operation**: O(1) - Direct array access
- **isEmpty()**: O(1) - Simple comparison
- **isFull()**: O(1) - Simple comparison
- **size()**: O(1) - Simple arithmetic

### Space Complexity
- **Overall**: O(n) where n is the capacity of the stack
- **Auxiliary Space**: O(1) - Only using a few variables

### Advantages
- Simple implementation
- Fast operations (all O(1))
- Memory efficient
- Easy to understand and debug

### Disadvantages
- Fixed size (not dynamic)
- Memory wastage if not fully utilized
- Stack overflow if capacity exceeded

---

*This implementation demonstrates fundamental stack operations with proper error handling and boundary condition checks.*