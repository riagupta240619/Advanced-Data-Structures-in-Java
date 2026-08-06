package Queue;
public class queue_prac {
    static int size = 10;
    static int front = -1;
    static int rear = -1;
    static int[] queue = new int[size];
    //adding an element to the queue
    static void enqueue(int[] arr, int element){
        if(rear == size - 1){
            System.out.println("Array is full");
            return;
        }
        if(front == -1){
            front = 0;
            rear = 0;
            arr[rear] = element;
        }else{
            rear++;
            arr[rear] = element;
        }
    }
    //implementing a circular queue
    static void circular_queue() {
        
    }
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        enqueue(queue, 3);
    }
}
