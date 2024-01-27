import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//효율성
//메모리 : 18084kb
//tlrks : 240ms

public class Q3190_Bokyung_Seong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int currentTime = 0;   //현재 시간
        boolean game = true;   //게임오버 체크

        //1 = apple, 2 = body, 0 = empty
        int[][] map = new int[n+2][n+2];  //게임판
        for(int i = 0; i < k; i++) {map[sc.nextInt()][sc.nextInt()] = 1;}

        //0 = right, 1 = down, 2 = left, 3 = up
        int directionIDX = 0;
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};

        //initial location
        Deque<int[]> body = new ArrayDeque<>(){ { offer(new int[]{1,1}); } };  //뱀의 몸
        map[1][1] = 2;  //게임판에서 뱀의 시작지점

        int l = sc.nextInt() - 1;       //회전 횟수
        int turnTime = sc.nextInt();    //회전 시간
        char dl = sc.next().charAt(0);  //회전 방향

        while(game){
            currentTime++;
            //머리 앞으로 한 칸 이동
            body.offer(new int[]{body.peekLast()[0]+x[directionIDX], body.peekLast()[1]+y[directionIDX]});

            //벽이거나 body면 종료
            if(body.peekLast()[0] > n || body.peekLast()[0] < 1
                    || body.peekLast()[1] > n || body.peekLast()[1] < 1
                    || map[body.peekLast()[0]][body.peekLast()[1]] == 2) {
                game = false;
            }
            //empty면 꼬리 당기기
            else if(map[body.peekLast()[0]][body.peekLast()[1]] == 0) {
                map[body.peek()[0]][body.peek()[1]] = 0;
                body.poll();
            }
            //apple이면 body 변화 없음

            //문제없으면 body로 설정
            map[body.peekLast()[0]][body.peekLast()[1]] = 2;

            //방향 변환 시간이면, 변환 후 다음 정보 받아오기.
            if(currentTime == turnTime){
                if(dl == 'D') directionIDX = ++directionIDX > 3 ? 0 : directionIDX;
                else directionIDX = --directionIDX < 0 ? 3 : directionIDX;

                //l이 0이면 더이상 회전 없음
                if(l > 0){
                    l--;
                    turnTime = sc.nextInt();
                    dl = sc.next().charAt(0);
                }
            }
        }
        System.out.println(currentTime);
        sc.close();
    }
}
