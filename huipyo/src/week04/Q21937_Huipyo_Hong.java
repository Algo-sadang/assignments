/**
 작업
 https://www.acmicpc.net/problem/21937
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 326400KB
 *  - 시간 : 1588ms
 */

package week04;

import java.util.*;
import java.util.function.Consumer;

public class Q21937_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    put(i + 1, new ArrayList<>());
                }
                for (int j = 0; j < m; j++) {
                    int a = scanner.nextInt(), b = scanner.nextInt();

                    get(b).add(a);
                }
            }
        };
        int x = scanner.nextInt();
        Set<Integer> visited = new HashSet<>(List.of(x));
        Consumer<Integer> dfs = new Consumer<>() {
            @Override
            public void accept(Integer current) {
                for (int next : graph.get(current)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    accept(next);
                }
            }
        };

        dfs.accept(x);
        System.out.println(visited.size() - 1);
        scanner.close();
    }
}
