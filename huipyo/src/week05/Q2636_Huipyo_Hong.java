/**
 치즈
 https://www.acmicpc.net/problem/2636
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 39456KB
 *  - 시간 : 756ms
 */

package week05;

import java.util.*;
import java.util.stream.IntStream;

public class Q2636_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt(), width = scanner.nextInt();
        int[][] grid = IntStream.range(0, height).mapToObj(operand -> IntStream.range(0, width).map(operand1 -> scanner.nextInt()).toArray()).toArray(int[][]::new);
        int time = 0;
        int lastCheese = 0;

        while (true) {
            int cheese = countCheese(grid);

            if (cheese == 0) {
                System.out.println(time);
                System.out.println(lastCheese);
                break;
            }
            if (lastCheese != cheese) lastCheese = cheese;
            time++;
            bfs(grid);
        }
        scanner.close();
    }

    private static void bfs(int[][] grid) {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new ArrayDeque<>(List.of(new AbstractMap.SimpleEntry<>(0, 0)));
        Set<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>(List.of(new AbstractMap.SimpleEntry<>(0, 0)));

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> current = queue.poll();
            int x = current.getKey();
            int y = current.getValue();

            for (int[] next : new int[][] {{x - 1, y}, {x, y + 1}, {x + 1, y}, {x, y - 1}}) {
                AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(next[0], next[1]);

                if (next[0] >= 0 && next[1] >= 0 && next[0] < grid.length && next[1] < grid[0].length && !visited.contains(key)) {
                    if (grid[next[0]][next[1]] == 1) {
                        grid[next[0]][next[1]] = 0;
                    } else if (grid[next[0]][next[1]] == 0) {
                        queue.offer(key);
                    }
                    visited.add(key);
                }
            }
        }
    }

    private static int countCheese(int[][] grid) {
        return (int) Arrays.stream(grid)
                .flatMapToInt(ints -> Arrays.stream(ints).filter(value -> value == 1))
                .count();
    }
}