/**
 부분수열의 합
 https://www.acmicpc.net/problem/1182
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 145792KB
 *  - 시간 : 560ms
 */

package week04;

import java.util.*;

public class Q1182_Huipyo_Hong {
    private static int mCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), s = scanner.nextInt();
        int[] array = new int[n];

        Arrays.setAll(array, i -> scanner.nextInt());
        backTracking(array, new Stack<>(), s, 0);
        System.out.println(mCount);
        scanner.close();
    }

    private static void backTracking(int[] array, Stack<Integer> stack, int s, int start) {
        for (int i = start; i < array.length; i++) {
            if (stack.contains(i)) continue;
            stack.push(i);
            if (sum(array, new ArrayList<>(stack)) == s) mCount++;
            if (stack.size() != array.length) backTracking(array, stack, s, i);
            stack.pop();
        }
    }

    private static int sum(int[] array, List<Integer> indices) {
        int sum = 0;

        for (int index : indices) {
            sum += array[index];
        }
        return sum;
    }
}