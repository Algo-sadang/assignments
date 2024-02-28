package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  [ 효율성 ]
 *  - 메모리: 346432KB
 *  - 시간 : 948ms
 */
public class Q15486_Minu {

    private static int[][] consulting;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 일자가 1부터 시작하므로, N + 1 크기의 배열을 생성
        consulting = new int[N + 1][2];
        dp = new int[N + 1];

        // 상담 완료 걸리는 기간과 상담금액을 consulting 2차원 배열에 저장
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            consulting[i][0] = Integer.parseInt(input[0]);
            consulting[i][1] = Integer.parseInt(input[1]);
        }


        for (int i = 1; i <= N; i++) {

            int day = consulting[i][0];
            int amount = consulting[i][1];

            // 현재 상담을 처리했을 때, 퇴사일을 넘어가지 않는다면, dp[i + day - 1]에 현재 상담을 처리했을 때의 금액을 저장
            if (i + day - 1 <= N) {
                dp[i + day - 1] = Math.max(dp[i + day - 1], dp[i - 1] + amount);
            }

            // 전날과 오늘 중 더 큰 금액을 저장
            // 주어진 N 일까지의 상담을 처리할 때, 최대 금액을 dp[N]에 저장되는 구조
            dp[i] = Math.max(dp[i], dp[i - 1]);

        }

        System.out.println(dp[N]);

    }

}