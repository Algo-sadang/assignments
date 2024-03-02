/**
 퇴사2
 https://www.acmicpc.net/problem/15486
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 345620KB
 *  - 시간 : 844ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15486_Daeun_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int maxVal = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int plus = arr[i][0];
            maxVal = Math.max(dp[i], maxVal);
            if (i + plus <= n) {
                dp[i+plus] = Math.max(arr[i][1] + maxVal, dp[i+plus]);
                result = Math.max(result, dp[i+plus]);
            }
        }
        System.out.println(result);
    }
}
