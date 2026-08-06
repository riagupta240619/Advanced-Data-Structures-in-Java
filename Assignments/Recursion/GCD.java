package Recursion;

public class GCD {
    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        
        System.out.println("GCD of " + num1 + " and " + num2 + ":");
        System.out.println("Using Recursive Method: " + gcdRecursive(num1, num2));
        System.out.println("Using Iterative Method: " + gcdIterative(num1, num2));
    }
}
