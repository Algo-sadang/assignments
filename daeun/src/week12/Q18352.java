import java.util.*;

public class Q18352 {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                // 도시의 개수 n, 도로의 개수 m, 거리 정보 k, 출발 도시의 번호 x
                int n = sc.nextInt(); int m = sc.nextInt(); int k = sc.nextInt(); int x = sc.nextInt();
                List<Integer>[] graph = new ArrayList[n+1];
                int[] dist = new int[n+1];
                boolean[] visited = new boolean[n+1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                for (int i = 0; i <= n; i++) {
                        graph[i] = new ArrayList<>();
                }
                for (int i=0; i<m; i++) {
                        int a = sc.nextInt();
                        int b = sc.nextInt();
                        graph[a].add(b);
                }
                Queue<Integer> q = new LinkedList<>();
                q.add(x);
                dist[x] = 0;
                while (!q.isEmpty()) {
                        int now = q.poll();
                        if (!visited[now]) {
                                visited[now] = true;
                        }
                        for (int next : graph[now]) {
                                if (!visited[next] && dist[next] > dist[now] + 1) {
                                        dist[next] = dist[now] + 1;
                                        q.add(next);
                                }
                        }
                }
                boolean notFound = true;
                for (int i=1; i<n+1; i++) {
                        if (dist[i] == k) {
                                System.out.println(i);
                                notFound = false;
                        }
                }
                if (notFound) {
                        System.out.println(-1);
                }
        }

}
