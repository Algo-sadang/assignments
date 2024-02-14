package week05;

import java.util.*;
import java.util.stream.IntStream;

public class Q2636_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt(), width = scanner.nextInt();
        int[][] grid = IntStream.range(0, height).mapToObj(operand -> IntStream.range(0, width).map(operand1 -> scanner.nextInt()).toArray()).toArray(int[][]::new);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Set<int[]> outsides = new HashSet<>();

                    bfs(grid, new int[] {i, j, 0}, outsides);
                    /*outsides.forEach(ints -> {
                        grid[ints[0]][ints[1]] = 0;
                    });*/
                }
            }
        }
        for (int[] a : grid) {
            System.out.println(Arrays.toString(a));
        }
        scanner.close();
    }

    private static void bfs(int[][] grid, int[] start, Set<int[]> outsides) {
        Queue<int[]> queue = new ArrayDeque<>(List.of(start));
        grid[start[0]][start[1]] = mark(grid, start, outsides);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] next : new int[][] {{current[0] - 1, current[1]}, {current[0], current[1] + 1}, {current[0] + 1, current[1]}, {current[0], current[1] - 1}}) {
                if (next[0] < 0 || next[1] < 0 || next[0] >= grid.length || next[1] >= grid[0].length) continue;
                if (grid[next[0]][next[1]] == 1) {
                    grid[next[0]][next[1]] = mark(grid, next, outsides);

                    queue.offer(new int[] {next[0], next[1], current[2] + 1});
                }
            }
        }
    }

    private static boolean isOutside(int[][] grid, int[] next) {
        for (int[] next1 : new int[][] {{next[0] - 1, next[1]}, {next[0], next[1] + 1}, {next[0] + 1, next[1]}, {next[0], next[1] - 1}}) {
            if (next1[0] < 0 || next1[1] < 0 || next1[0] >= grid.length || next1[1] >= grid[0].length) continue;
            if (grid[next1[0]][next1[1]] == 0) return true;
        }
        return false;
    }

    private static int mark(int[][] grid, int[] pos, Set<int[]> outsides) {
        if (isOutside(grid, pos)) {
            outsides.add(pos);
            return 3;
        } else return 2;
    }
}