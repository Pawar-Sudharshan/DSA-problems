package day3.Queue_implement_using_stack;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        
        // Test the queue implementation
        System.out.println("Testing MyQueue implementation:");
        
        // Push some elements
        queue.push(1);
        queue.push(2);
        queue.push(3);
        
        System.out.println("Peek: " + queue.peek()); // Should output 1
        System.out.println("Pop: " + queue.pop());   // Should output 1
        System.out.println("Pop: " + queue.pop());   // Should output 2
        System.out.println("Empty: " + queue.empty()); // Should output false
        System.out.println("Pop: " + queue.pop());   // Should output 3
        System.out.println("Empty: " + queue.empty()); // Should output true
    }
}