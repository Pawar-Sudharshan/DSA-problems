package day2.queue;
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