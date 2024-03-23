package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  [ 효율성 ]
 *  - 메모리: 119440 KB
 *  - 시간 : 536	ms
 */
public class Q2805_Minu {

    static int[] tree;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위해 first와 last를 설정
        int first = 0;
        int last = Arrays.stream(tree).max().getAsInt(); // 나무 중 최대 높이 설정
        int mid; // 중간값을 나타내는 변수를 선언
        long maxNum; // 특정 높이에서의 나무의 길이 합을 저장할 변수를 선언

        // 이진 탐색
        while (first <= last) {
            mid = (first + last) / 2; // 중간값
            maxNum = getTree(mid); // 특정 높이에서의 나무의 길이 합을 계산

            // 나무의 길이 합이 M보다 작으면 last를 조정하여 높이를 더 낮춤
            if (maxNum < M) {
                last = mid - 1;
            } else { // 나무의 길이 합이 M보다 크거나 같으면 first를 조정하여 높이를 높임
                first = mid + 1;
            }
        }

        // 최종적으로 구해진 높이를 출력
        System.out.println(last);
    }

    // 특정 높이에서의 나무의 길이 합을 계산하는 메서드
    public static long getTree(int mid) {
        long maxNum = 0;
        for (int t : tree) {
            // 현재 나무의 높이가 특정 높이(mid)보다 크다면 자른 나무의 길이를 더함
            if (t > mid) {
                maxNum += (t - mid);
            }
        }
        return maxNum;
    }

}