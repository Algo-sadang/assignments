package P2024_01;

import java.util.*;

/**
 *
 * 메모리 : 17815KB
 * 시간 : 236ms
 * 코드 길이 : 827B
 *
 */

public class B_1182 {

    static int[] n;
    static List<Integer> list;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = new int[]{sc.nextInt(), sc.nextInt()};
        list = new ArrayList<>();
        for (int i = 0; i < n[0]; i++) {
            list.add(sc.nextInt());
        }
        findResult(0, 0);
        if(n[1] == 0) count--;
        System.out.println(count);
        sc.close();
    }
    static void findResult(int index, int sum) {
        if(index == n[0]) {
            if(sum == n[1]) {
                count++;
            }
            return;
        }
        findResult(index + 1, sum + list.get(index));
        findResult(index + 1, sum);
    }
}
