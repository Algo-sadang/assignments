package week01;

import java.util.*;

public class Q2841_Daeun_Kim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 음의 수
        int P = sc.nextInt(); // 프렛의 수
        int answer = 0;
        List<Stack<Integer>> stackList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stackList.add(new Stack<>());
        }
        for (int i=0; i<N; i++) {
            int lineNum = sc.nextInt();
            int fretNum = sc.nextInt();
            while (!stackList.get(lineNum).isEmpty() && (stackList.get(lineNum).peek() > fretNum)) {
                stackList.get(lineNum).pop();
                answer += 1;
            }
            if (stackList.get(lineNum).isEmpty() || (stackList.get(lineNum).peek() != fretNum)) {
                stackList.get(lineNum).push(fretNum);
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
