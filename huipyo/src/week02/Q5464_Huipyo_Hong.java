/**
 주차장
 https://www.acmicpc.net/problem/5464
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 26064KB
 *  - 시간 : 360ms
 */

package week02;

import java.util.*;
import java.util.function.Function;

public class Q5464_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, Integer> rsMap = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) put(i, scanner.nextInt());
            }
        };
        Map<Integer, Integer> wkMap = new HashMap<>() {
            {
                for (int j = 0; j < m; j++) put(j + 1, scanner.nextInt());
            }
        };
        int[] array = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        Function<Integer, Integer> linearSearch = (target) -> {
            for (int i = 0; i < array.length; i++)
                if (array[i] == target) {
                    return i;
                }
            return -1;
        };
        int answer = 0;

        for (int i = 0; i < 2 * m; i++) {
            int input = scanner.nextInt();
            int index = linearSearch.apply(input > 0 ? 0 : -input);

            if (index < 0) {
                queue.offer(input);
            } else {
                array[index] = Math.max(input, queue.isEmpty() ? 0 : queue.poll());
                answer += wkMap.getOrDefault(array[index], 0) * rsMap.get(index);
                // 디버깅용 코드
                // 주석풀어서 확인할 수 있음
                //System.out.println(Arrays.toString(array) + " queue: " + queue + ", index: " + index + ", " + (wkMap.getOrDefault(array[index], 0) * rsMap.getOrDefault(index, 0)));
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}