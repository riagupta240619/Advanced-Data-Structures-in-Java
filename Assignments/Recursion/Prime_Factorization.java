package Recursion;

import java.util.Scanner;
class Main{
    public static void print(int n , int a){
        if (n > 1) {
            if(n % a == 0){
                System.out.println(a);
                print(n / a, a);
            } else {
                print(n, a + 1);
            }
        }
    }
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            print(n, 2);
        }
    }
}
