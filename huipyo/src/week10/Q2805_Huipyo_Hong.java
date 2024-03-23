/**
 나무 자르기
 https://www.acmicpc.net/problem/2805
 */

package week10;

import java.util.*;

public class Q2805_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<Integer> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) add(scanner.nextInt());
            }
        };
        int min = Collections.min(list), max = Collections.max(list);

        Collections.sort(list);
        while (min <= max) {
            int mid = (min + max) / 2;

            if (operation(list, mid) >= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
        scanner.close();
    }

    private static long operation(List<Integer> list, int num) {
        long result = 0;

        for (int element : list) {
            if (element > num) result += (element - num);
        }
        return result;
    }
}