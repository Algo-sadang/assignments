package week02;

import java.util.*;
import java.util.function.Function;

public class Q5464_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, Integer> rsMap = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) put(i, scanner.nextInt());
            }
        };
        Map<Integer, Integer> wkMap = new HashMap<>() {
            {
                for (int j = 0; j < m; j++) put(j + 1, scanner.nextInt());
            }
        };
        int[] array = new int[n];
        Queue<Integer> queue = new ArrayDeque<>() {
            {
                for (int i = 0; i < 2 * m; i++) offer(scanner.nextInt());
            }
        };
        Function<Integer, Integer> linearSearch = (target) -> {
            for (int i = 0; i < array.length; i++) if (array[i] == target) {
                return i;
            }
            return -1;
        };
        int answer = 0;

        while (!queue.isEmpty()) {
            int outed = queue.poll();
            int index = linearSearch.apply(outed > 0 ? 0 : -outed);

            if (index < 0) {
                queue.offer(outed);
            } else {
                array[index] = Math.max(outed, 0);
                answer += wkMap.getOrDefault(outed, 0) * rsMap.get(index);
            }
            System.out.println("222 " + Arrays.toString(array) + " queue: " + queue + ", index: " + index + ", " + (wkMap.getOrDefault(outed, 0) * rsMap.getOrDefault(index, 0)));
        }
        System.out.println(rsMap);
        System.out.println(wkMap);
        System.out.println(answer);
        scanner.close();
    }
}

/**
 * j: 2 200 2, 100, queue: [2, 4]
 * j: 1 5000 5, 1000, queue: [4]
 * j: 2 1000 2, 500, queue: []
 * j: 1 10000 5, 2000, queue: []
 */