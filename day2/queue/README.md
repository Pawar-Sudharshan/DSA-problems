# Day 2: Queue Data Structure Implementation

## Problem Statement

Implement a Queue data structure using array with all fundamental operations including enqueue, dequeue, peek, and utility methods. The queue follows the First-In-First-Out (FIFO) principle where elements are inserted at the rear and removed from the front.

**Key Operations to Implement:**
- `enqueue(item)`: Add an element to the rear of the queue
- `dequeue()`: Remove and return the front element from the queue
- `peek()`: Return the front element without removing it
- `isEmpty()`: Check if the queue is empty
- `isFull()`: Check if the queue has reached maximum capacity
- `size()`: Get the current number of elements in the queue
- `display()`: Print all elements in the queue

## Constraints

- Maximum queue capacity: User-defined (configurable)
- Elements must be integers
- Handle overflow condition when queue is full
- Handle underflow condition when queue is empty
- Use circular array implementation for optimal space utilization
- Memory efficiency: O(n) where n is the maximum capacity

## Approach

### Circular Queue Implementation
We use a **circular queue** approach to maximize space efficiency:

1. **Array-based Storage**: Use a fixed-size integer array to store queue elements
2. **Two Pointers System**:
   - `front`: Points to the first element (for dequeue operations)
   - `rear`: Points to the last inserted element (for enqueue operations)
3. **Circular Logic**: Use modulo arithmetic to wrap around array indices
4. **Count Tracking**: Maintain a separate counter for current size

### Key Algorithm Steps:

**Enqueue Operation:**
1. Check if queue is full
2. If not full: increment rear pointer (with wraparound), insert element, increment count
3. If full: display overflow message

**Dequeue Operation:**
1. Check if queue is empty
2. If not empty: get front element, increment front pointer (with wraparound), decrement count
3. If empty: display underflow message

**Circular Wraparound Formula:**
- `rear = (rear + 1) % capacity`
- `front = (front + 1) % capacity`

## Code Implementation (Java)

```java
import java.util.*;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor
    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        System.out.println("Enqueued: " + item);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue from empty queue");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return count == capacity;
    }

    // Get current size
    public int size() {
        return count;
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Queue Implementation Demo");
        System.out.println("=========================");
        
        Queue queue = new Queue(5);
        
        // Test enqueue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        
        // Test peek operation
        System.out.println("Front element: " + queue.peek());
        
        // Test dequeue operations
        queue.dequeue();
        queue.dequeue();
        queue.display();
        
        // Test more operations
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();
        
        // Test overflow
        queue.enqueue(80);
        
        // Test underflow
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        queue.dequeue(); // This should show underflow
    }
}
```

## Dry Run Examples

### Example 1: Basic Queue Operations

**Initial State:** Queue with capacity = 5
- Array: [_, _, _, _, _]
- front = 0, rear = -1, count = 0

**Step 1: enqueue(10)**
- rear = (−1 + 1) % 5 = 0
- arr[0] = 10, count = 1
- Array: [10, _, _, _, _]
- front = 0, rear = 0, count = 1

**Step 2: enqueue(20)**
- rear = (0 + 1) % 5 = 1
- arr[1] = 20, count = 2
- Array: [10, 20, _, _, _]
- front = 0, rear = 1, count = 2

**Step 3: enqueue(30)**
- rear = (1 + 1) % 5 = 2
- arr[2] = 30, count = 3
- Array: [10, 20, 30, _, _]
- front = 0, rear = 2, count = 3

**Step 4: dequeue()**
- item = arr[0] = 10
- front = (0 + 1) % 5 = 1
- count = 2
- Array: [_, 20, 30, _, _] (front now at index 1)
- Returns: 10

**Step 5: peek()**
- Returns: arr[1] = 20 (without removing)

### Example 2: Circular Wraparound Demonstration

**Initial State:** Queue with capacity = 3, filled with [10, 20, 30]
- Array: [10, 20, 30]
- front = 0, rear = 2, count = 3

**Step 1: dequeue()**
- item = 10, front = 1, count = 2
- Array: [_, 20, 30] (front at index 1)

**Step 2: dequeue()**
- item = 20, front = 2, count = 1
- Array: [_, _, 30] (front at index 2)

**Step 3: enqueue(40)**
- rear = (2 + 1) % 3 = 0 (wraparound!)
- arr[0] = 40, count = 2
- Array: [40, _, 30] (reusing index 0)
- front = 2, rear = 0, count = 2

**Step 4: enqueue(50)**
- rear = (0 + 1) % 3 = 1
- arr[1] = 50, count = 3
- Array: [40, 50, 30]
- front = 2, rear = 1, count = 3

**Display Order:** 30 → 40 → 50 (following FIFO from front)

### Example 3: Overflow and Underflow Cases

**Overflow Test:**
- Queue capacity = 3, already full with [10, 20, 30]
- enqueue(40) → Output: "Queue Overflow! Cannot enqueue 40"
- Queue remains: [10, 20, 30]

**Underflow Test:**
- Empty queue (count = 0)
- dequeue() → Output: "Queue Underflow! Cannot dequeue from empty queue"
- Returns: -1
- peek() → Output: "Queue is empty"
- Returns: -1

## Key Insights

1. **FIFO Principle**: Queue strictly follows First-In-First-Out ordering, making it ideal for scenarios like task scheduling, breadth-first search, and buffering.

2. **Circular Array Advantage**: 
   - Eliminates the need to shift elements when dequeuing
   - Provides O(1) time complexity for all operations
   - Maximizes space utilization by reusing deallocated positions

3. **Two-Pointer System**: 
   - Separate front and rear pointers enable efficient insertion and deletion
   - Modulo arithmetic ensures proper wraparound in circular implementation

4. **Count-Based Full/Empty Detection**:
   - More reliable than pointer comparison methods
   - Handles edge cases where front and rear pointers might be equal

5. **Error Handling**: 
   - Proper overflow/underflow detection prevents runtime errors
   - Graceful handling of edge cases improves robustness

6. **Display Implementation**: 
   - Traverses from front to rear using circular logic
   - Shows elements in FIFO order regardless of their physical array positions

7. **Memory Efficiency**: 
   - Fixed-size array prevents dynamic memory allocation overhead
   - Suitable for systems with memory constraints

## Complexity Analysis

### Time Complexity:
- **Enqueue**: O(1) - Direct array access with index calculation
- **Dequeue**: O(1) - Direct array access with index calculation
- **Peek**: O(1) - Direct access to front element
- **isEmpty**: O(1) - Simple count comparison
- **isFull**: O(1) - Simple count comparison
- **Size**: O(1) - Return stored count value
- **Display**: O(n) - Must traverse all elements in queue

### Space Complexity:
- **Overall**: O(n) where n is the maximum capacity
- **Auxiliary Space**: O(1) - Only uses a few integer variables for bookkeeping
- **No Dynamic Allocation**: Fixed space allocation during initialization

### Comparative Analysis:
- **vs. Linear Array Queue**: Eliminates O(n) shifting overhead in dequeue
- **vs. Linked List Queue**: Better cache locality, no pointer overhead
- **vs. Dynamic Array Queue**: Predictable memory usage, no resizing overhead

**Best Use Cases:**
- Real-time systems requiring predictable performance
- Memory-constrained environments
- High-frequency enqueue/dequeue operations
- Scenarios where maximum queue size is known in advance