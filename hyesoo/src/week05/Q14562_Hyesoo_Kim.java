package week05;
/**
 * 태권왕
 * https://www.acmicpc.net/problem/14562
 * [ 효율성 ]
 * - 메모리: 18516KB
 * - 시간 : 240ms
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14562_Hyesoo_Kim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
        }

        scanner.nextLine();

        for(int[] e: arr) {
            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{e[0], e[1], 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                if (cur[0] == cur[1]) {
                    System.out.println(cur[2]);
                    break;
                }
                else if (cur[0] < cur[1]) {
                    q.offer(new int[]{cur[0] * 2, cur[1] + 3, cur[2] + 1});
                    q.offer(new int[]{cur[0] + 1, cur[1], cur[2] + 1});
                }
            }
        }

        scanner.close();
    }

}
