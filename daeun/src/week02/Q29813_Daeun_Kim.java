package week02;

import java.util.*;

public class Q29813_Daeun_Kim {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new ArrayDeque();
        Map<String, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String name = sc.next();
            int code = sc.nextInt();
            queue.add(name);
            map.put(name, code);
        }
        while (queue.size() > 1) {
            String front = queue.poll();
            for (int i=0; i<map.get(front)-1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}
