package Prefix_Suffix;

import java.util.Scanner;

public class Suffix {
    public static int[] suffixSum(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] + arr[i];
        }
        return suffix;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int[] suffix = suffixSum(arr);
            System.out.println("Suffix sums:");
            for (int i = 0; i < n; i++) {
                System.out.println(suffix[i]);
            }
        }
    }
}

