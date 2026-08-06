package Array;

public class Rotate_an_array {
    public static int[] rotateModulus(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        k = ((k % n) + n) % n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        return rotated;
    }

    public static int[] rotateReversal(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        k = ((k % n) + n) % n;
        int[] result = arr.clone();
        reverse(result, 0, n - 1);
        reverse(result, 0, k - 1);
        reverse(result, k, n - 1);
        return result;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.print("Original: ");
        printArray(array);

        System.out.print("Modulus: ");
        printArray(rotateModulus(array, k));

        System.out.print("Reversal: ");
        printArray(rotateReversal(array, k));
    }
}
