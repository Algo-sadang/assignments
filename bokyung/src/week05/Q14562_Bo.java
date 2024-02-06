package week05;

import java.util.*;

public class Q14562_Bo {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tn = sc.nextInt(); //the number of test cases

        for(int i = 0; i < tn; i++){
            int s = sc.nextInt(), t = sc.nextInt();
            bfs(s, t, 0);
            //s와 t가 같아지는 경우의 수 중에 최소 count를 출력
            System.out.println(Collections.min(list));
            list.clear();
        }
    }

    public static void bfs (int s, int t, int count){
        //같을 때 list에 count 추가
        if(s == t){
            list.add(count);
            return;
        }
        // s > t면 재귀 종료
        if(s > t) return;

        //평범한 돌려차기
        bfs(s + 1, t, count + 1);
        //엄청난 돌려차기
        bfs(s * 2, t + 3, count + 1);
    }
}





