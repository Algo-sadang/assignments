package week04; /**
 * 작업
 * https://www.acmicpc.net/problem/21937
 *  [ 효율성 ]
 *  - 메모리: 335084KB
 *  - 시간 : 1768ms
 */

import java.util.*;


public class Q21937_Hyesoo_Kim {
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];

        scanner.nextLine();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            map.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
        }

        int target = scanner.nextInt();
        dfs(target, map);

        scanner.close();

        System.out.println(count);
    }

    public static void dfs(int num, Map<Integer, List<Integer>> map) {
        for(int n : map.getOrDefault(num, new ArrayList<>())) {
            if(!visited[n]) {
                visited[n] = true;
                count++;
                dfs(n, map);
            }
        }
    }

}