package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  [ 효율성 ]
 *  - 메모리: 24200 KB
 *  - 시간 : 272	ms
 */
public class Q14246_Minu {

    static int N, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());

        // 시작 인덱스와 끝 인덱스, 부분합, 결과값을 초기화
        int start = 0;
        int end = 0;
        long sum = 0;
        long result = 0;

        // 부분합을 구함
        while (true) {
            // 부분합이 k보다 큰 경우
            if (sum > k) {
                // 현재 start부터 end까지의 부분합이 k보다 크므로
                // start를 증가시키고, 결과값에 해당하는 부분합의 개수를 더함
                result += N - end + 1;
                // start에 해당하는 값을 부분합에서 제거
                sum -= arr[start++];
            } else if (end >= N) {
                // end가 배열의 끝에 도달하면 종료
                break;
            } else {
                // 부분합이 k보다 작은 경우 end에 해당하는 값을 부분합에 더함
                sum += arr[end++];
            }
        }

        // 결과값 출력
        System.out.println(result);
    }

}