package week06;
/**
 * 사탕게임
 * https://www.acmicpc.net/problem/3085
 * [ 효율성 ]
 * - 메모리: 17844KB
 * - 시간 : 276ms
 */

import java.util.Scanner;

public class Q3085_Hyesoo_Kim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine().toCharArray();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Check rows
                swap(arr, i, j, i, j + 1);
                max = Math.max(max, countMaxCandy(arr));
                swap(arr, i, j + 1, i, j);

                // Check columns
                swap(arr, j, i, j + 1, i);
                max = Math.max(max, countMaxCandy(arr));
                swap(arr, j + 1, i, j, i);
            }
        }

        System.out.println(max);
        scanner.close();
    }

    private static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static int countMaxCandy(char[][] arr) {
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int rowCount = 1;
            int colCount = 1;
            for (int j = 1; j < arr.length; j++) {
                // Row check
                if (arr[i][j] == arr[i][j - 1]) rowCount++;
                else rowCount = 1;

                // Column check
                if (arr[j][i] == arr[j - 1][i]) colCount++;
                else colCount = 1;

                max = Math.max(max, Math.max(rowCount, colCount));
            }
        }
        return max;
    }
}
