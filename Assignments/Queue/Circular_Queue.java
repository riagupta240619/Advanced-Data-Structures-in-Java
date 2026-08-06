package Queue;

import java.util.*;
class Circular_Queue{
    static int size = 5;
    static int front = -1;
    static int rear = -1;
    static int[] queue = new int[size];
    //enqueue -> adding element if space is available
    static void enqueue(int element) {
        // Queue is full
        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full");
            return;
        }
        // First element
        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = element;
    }

    // Dequeue
    static int dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int value = queue[front];
        // Only one element left
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return value;
    }

    // Peek
    static int peek() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    // Display
    static void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        display();
        System.out.println("Deleted : " + dequeue());
        System.out.println("Deleted : " + dequeue());
        display();
        enqueue(60);
        enqueue(70);
        display();
        System.out.println("Front : " + peek());
    }
}