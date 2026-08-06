package Prefix_Suffix;

public class Prefix {
    public static int[] prefixSum(int[] arr) {
        if (arr == null) {
            return null;
        }
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = prefixSum(arr);
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
