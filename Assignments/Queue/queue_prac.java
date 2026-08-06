package Queue;
import java.util.*;
public class queue_prac {
    static int size = 10;
    static int front = -1;
    static int rear = -1;
    static int[] queue = new int[size];
    //adding an element to the queue
    static void enqueue(int element){
        if(rear == size - 1){
            System.out.println("Array is full");
            return;
        }
        if(front == -1){
            front = 0;
            rear = 0;
            queue[rear] = element;
        }else{
            rear++;
            queue[rear] = element;
        }
    }

//    dequeue -> removing an element from the queue
    static int dequeue() {
        if (front == -1) {
            System.out.println("Array is Empty");
            return -1;
        }
        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return value;
    }
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         enqueue(n);
         enqueue(6);
         enqueue(7);
         System.out.println(dequeue());
         System.out.println(dequeue());
    }
}
