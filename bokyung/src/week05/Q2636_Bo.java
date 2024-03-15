package week05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2636_Bo {
    static int[][] move = {{0, -1},{-1, 0},{1, 0},{0, 1}};
    static boolean[][] cheese;  //치즈가 있는지 없는지
    static boolean[][] visited; //방문했는지 안했는지
    static int nCheese = 0; //치즈의 총 개수
    static int hours  = 0; //경과시간
    static int x, y;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();

        cheese = new boolean[x][y];
        visited = new boolean[x][y];

        //치즈판 입력
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(sc.nextInt() == 1){
                    cheese[i][j] = true;
                    nCheese++;
                }
            }
        }

        int oneHourAgo = nCheese; //1시간 전 남은 치즈의 개수

        //치즈가 하나도 남지 않을 때까지 반복
        while(nCheese != 0){
            bfs(0, 0);

            //방문 초기화
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    visited[i][j] = false;
                }
            }

            //1시간 경과
            hours++;

            //치즈가 아직 남아있을 때, 남은 치즈의 개수를 저장
            if(nCheese != 0) oneHourAgo = nCheese;
        }

        System.out.println(hours);
        System.out.println(oneHourAgo);
        sc.close();
    }

    public static void bfs(int xx, int yy){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{xx,yy});
        visited[xx][yy] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + move[i][0];
                int ny = now[1] + move[i][1];

                if(nx >= 0 && ny >= 0 && nx < x && ny < y && !visited[nx][ny]){
                    //치즈가 있는 칸
                    if(cheese[nx][ny]){
                        //치즈가 녹아 사라짐
                        cheese[nx][ny] = false;
                        nCheese--;
                    }
                    //치즈가 없는 칸
                    else{
                        q.add(new int[]{nx, ny});
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
