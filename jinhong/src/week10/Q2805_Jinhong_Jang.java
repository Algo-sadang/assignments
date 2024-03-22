package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805_Jinhong_Jang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) trees[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees);
        int start = 0, end = trees[n - 1];


        while (start < end) {
            int mid = (start + end) / 2;
            long len = 0;

            for (int t : trees) {
                /*
                 * len = "나무의 높이 - 자르는 위치"의 합
                 * 자르는 위치 < 나무의 높이인 경우에만 합을 계산
                 * (절단기 설정 가능 높이는 양의 정수, 0만 가능함)
                 */
                if(t - mid > 0)
                    len += (t - mid);
            }

            if(len < m)
                end = mid;

            /*
            * 반대의 경우(필요한 길이를 넘길 경우, 자른 합과 필요한 목재 길이가 같을 경우)
            * 많이 잘라내야 하므로, 높이를 높여야 한다.
            */
            else
                start = mid + 1;
        }

        // 자른 합과 목재 길이가 같은 경우에도 +1을 해주었으므로, 결과값은 -1해주어야 함.
        System.out.println(start - 1);
    }
}
