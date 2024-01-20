/**
 최애의 팀원
 https://www.acmicpc.net/problem/29813
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 22288KB
 *  - 시간 : 300ms
 */

package week02;

import java.util.*;

public class Q29813_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<AbstractMap.SimpleEntry<String, Integer>> queue = new ArrayDeque<>() {
            {
                for (int i = 0; i < n; i++) offer(new AbstractMap.SimpleEntry<>(scanner.next(), scanner.nextInt()));
            }
        };

        while (queue.size() > 1) {
            AbstractMap.SimpleEntry<String, Integer> outed = queue.poll();

            for (int i = 1; i < outed.getValue(); i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        if (!queue.isEmpty()) {
            System.out.println(queue.poll().getKey());
        }
        scanner.close();
    }
}
