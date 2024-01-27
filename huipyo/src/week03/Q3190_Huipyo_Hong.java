/**
 뱀
 https://www.acmicpc.net/problem/3190
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 18720KB
 *  - 시간 : 268ms
 */

package week03;

import java.util.*;

public class Q3190_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arrays = initArrays(scanner, n, k);
        int l = scanner.nextInt();
        Map<Integer, String> dirMap = new HashMap<>() {
            {
                for (int i = 0; i < l; i++) {
                    put(scanner.nextInt(), scanner.next());
                }
            }
        };

        System.out.println(simulate(arrays, dirMap));
        scanner.close();
    }

    private static int simulate(int[][] arrays, Map<Integer, String> dirMap) {
        Deque<AbstractMap.SimpleEntry<Integer, Integer>> deque = new ArrayDeque<>(List.of(new AbstractMap.SimpleEntry<>(0, 0)));
        int count = 0;
        Direction dir = Direction.Right;
        arrays[0][0] = 2;

        while (!deque.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> head = deque.peekFirst();
            int headI = head.getKey(), headJ = head.getValue();

            switch (dir) {
                case Up:
                    headI--;
                    break;
                case Right:
                    headJ++;
                    break;
                case Down:
                    headI++;
                    break;
                case Left:
                    headJ--;
                    break;
            }
            if (headI >= arrays.length || headI < 0 || headJ >= arrays[headI].length || headJ < 0 || arrays[headI][headJ] == 2) {
                return count + 1;
            }
            if (arrays[headI][headJ] == 1) {
                arrays[headI][headJ] = 2;
            } else {
                AbstractMap.SimpleEntry<Integer, Integer> tail = deque.pollLast();
                int tailI = tail.getKey(), tailJ = tail.getValue();
                arrays[headI][headJ] = 2;
                arrays[tailI][tailJ] = 0;
            }
            deque.offerFirst(new AbstractMap.SimpleEntry<>(headI, headJ));
            count++;
            if (dirMap.get(count) != null) {
                String direction = dirMap.get(count);

                switch (dir) {
                    case Up:
                        dir = direction.equals("L") ? Direction.Left : Direction.Right;
                        break;
                    case Right:
                        dir = direction.equals("L") ? Direction.Up : Direction.Down;
                        break;
                    case Down:
                        dir = direction.equals("L") ? Direction.Right : Direction.Left;
                        break;
                    case Left:
                        dir = direction.equals("L") ? Direction.Down : Direction.Up;
                        break;
                }
            }
        }
        return 0;
    }

    private static int[][] initArrays(Scanner scanner, int n, int k) {
        int[][] arrays = new int[n][n];

        for (int i = 0; i < k; i++) {
            arrays[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
        }
        return arrays;
    }

    enum Direction {
        Up, Down, Left, Right
    }
}
