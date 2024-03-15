package week09;

import java.util.*;

public class Q1459_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(), y = scanner.nextInt(), w = scanner.nextInt(), s = scanner.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2])) { { offer(new int[] {0, 0, 0}); } };
        Set<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>(List.of(new AbstractMap.SimpleEntry<>(0, 0)));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == x && current[1] == y) {
                System.out.println(current[2]);
                break;
            }
            for (int[] next : new int[][] {
                    {current[0] - 1, current[1], w},
                    {current[0] - 1, current[1] - 1, s},
                    {current[0], current[1] + 1, w},
                    {current[0] + 1, current[1] + 1, s},
                    {current[0] + 1, current[1], w},
                    {current[0] + 1, current[1] - 1, s},
                    {current[0], current[1] - 1, w},
                    {current[0] - 1, current[1] - 1, s}
            }) {
                if (next[0] > -1 && next[1] > -1 && !visited.contains(new AbstractMap.SimpleEntry<>(next[0], next[1]))) {
                    visited.add(new AbstractMap.SimpleEntry<>(next[0], next[1]));
                    queue.offer(new int[] {next[0], next[1], current[2] + next[2]});
                }
            }
        }
        scanner.close();
    }
}
