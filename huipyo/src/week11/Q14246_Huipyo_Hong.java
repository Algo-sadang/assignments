package week11;

import java.util.Scanner;
import java.util.*;

public class Q14246_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = initArray(n, scanner);
        long[] prefixSum = initPrefixSum(n, array);
        long k = scanner.nextLong();
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0) > k) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }

    private static int[] initArray(int n, Scanner scanner) {
        int[] result = new int[n];

        Arrays.setAll(result, i -> scanner.nextInt());
        return result;
    }

    private static long[] initPrefixSum(int n, int[] array) {
        long[] prefixSum = new long[n];
        prefixSum[0] = array[0];

        Arrays.setAll(prefixSum, i -> i == 0 ? array[0] : prefixSum[i - 1] + array[i]);
        return prefixSum;
    }
}
