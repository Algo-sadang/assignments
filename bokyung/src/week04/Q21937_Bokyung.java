package week04;

import java.util.*;

public class Q21937_Bokyung {
    static Map<Integer, List<Integer>> order;
    static int n, m;
    static int mCount = 0;

    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        order = new HashMap<>();
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            int before = sc.nextInt();
            int after = sc.nextInt();
            order.computeIfAbsent(after, temp -> new ArrayList<>()).add(before);
        }

        dfs(sc.nextInt());
        System.out.println(mCount);
    }

    public static void dfs(int after){
        if(order.get(after) == null || visited[after]) return;

        visited[after] = true;
        mCount++;

        for(int i : order.get(after)){
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
