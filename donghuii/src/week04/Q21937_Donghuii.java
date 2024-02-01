package P2024_01;

import java.util.*;

/**
 * 메모리 : 314932KB
 * 시간 : 1580ms
 */

public class Q21937 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[]> list = new ArrayList<>(){{
            for (int i = 0; i < m; i++) {
                int[] arr = new int[]{sc.nextInt(), sc.nextInt()};
             add(arr);
            }
        }
        };
        int x = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>(){{
            for (int i = 1; i <= n ; i++) {
                put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                get(list.get(i)[1]).add(list.get(i)[0]);
            }
        }};

        System.out.println(map);
        Set<Integer> set = new HashSet<>();
        set.add(x);
        Stack<Integer> stack = new Stack<>();
        stack.push(x);
        while (!stack.isEmpty()) {
            int current = stack.pop();

            for(int next : map.getOrDefault(current, new ArrayList<>())) {
                if (!set.contains(next)) {
                    stack.push(next);
                    set.add(next);
                }
            }
        }
        System.out.println(set.size() - 1);
        sc.close();
    }
}
