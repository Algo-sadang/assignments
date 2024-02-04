/**
 태권왕
 https://www.acmicpc.net/problem/14562
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 18196KB
 *  - 시간 : 248ms
 */

package week05;

import java.util.*;

public class Q14562_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();

        while (c-- > 0) {
            int s = scanner.nextInt(), t = scanner.nextInt();
            int result = solution(s, t);

            System.out.println(result);
        }
        scanner.close();
    }

    private static int solution(int s, int t) {
        Queue<Triple<Integer, Integer, Integer>> queue = new ArrayDeque<>(List.of(new Triple<>(s, t, 0)));

        while (!queue.isEmpty()) {
            Triple<Integer, Integer, Integer> current = queue.poll();
            int[] nexts = {current.first * 2, current.first + 1};

            if (current.first.intValue() == current.second.intValue()) {
                return current.third;
            }
            for (int i = 0; i < nexts.length; i++) {
                int first = nexts[i];
                int second = current.second + (i == 0 ? 3 : 0);

                if (first > second) continue;
                queue.offer(new Triple<>(first, second, current.third + 1));
            }
        }
        return 0;
    }
}

class Triple<F, S, T> {
    F first; // 나의 점수

    S second; // 상대 점수

    T third; // 단계

    public Triple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}