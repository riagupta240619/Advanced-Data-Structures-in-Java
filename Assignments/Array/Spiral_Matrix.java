package Array;

import java.util.*;
public class Spiral_Matrix {
    public static List<List<Integer>> spiral_matrix(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            List<Integer> layer = new ArrayList<>();
            // Top Row
            for (int i = left; i <= right; i++) {
                layer.add(matrix[top][i]);
            }
            top++;
            // Right Column
            for (int i = top; i <= bottom; i++) {
                layer.add(matrix[i][right]);
            }
            right--;
            // Bottom Row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    layer.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Left Column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    layer.add(matrix[i][left]);
                }
                left++;
            }
            res.add(layer);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        List<List<Integer>> res = spiral_matrix(arr);
        System.out.println(res);
    }
}