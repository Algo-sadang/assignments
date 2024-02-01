package week04; /**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 *  [ 효율성 ]
 *  - 메모리: 17816KB
 *  - 시간 : 212ms
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q1182_Hyesoo_Kim {
    static int[] arr;
    static int s;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        s = scanner.nextInt();

        scanner.nextLine();

        arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        dfs(0, 0);

        scanner.close();

        System.out.println(s==0? count-1 : count);
    }

    public static void dfs(int index, int sum) {
        if(index == arr.length) {
            if(sum == s) count++;
            return;
        }

        dfs(index+1, sum + arr[index]);
        dfs(index+1, sum);
    }

}
