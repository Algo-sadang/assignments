package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  [ 효율성 ]
 *  - 메모리: 14360KB
 *  - 시간 : 188ms
 */
public class Q3085_Minu {

    private static int N;
    private static char[][] candy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 사탕 상자의 크기
        candy = new char[N][N]; // 사탕 상자

        // 사탕 상자에 사탕 채우기
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                candy[i][j] = input.charAt(j);
            }
        }

        System.out.println(findMaxValueCandies());

    }

    private static int findMaxValueCandies() {

        int result = 0;

        // 사탕 상자를 돌면서 사탕을 바꿔가며 최대값 찾기
        // 첫번째 루프문은 가로방향으로 사탕을 바꿔가며 최대값을 찾음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                result = Math.max(result, check());
                swap(i, j, i, j + 1);
            }
        }

        // 두번째 루프문은 각 세로방향으로 사탕을 바꿔가며 최대값을 찾음
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                result = Math.max(result, check());
                swap(i, j, i + 1, j);
            }
        }

        return result;
    }

    // 두 사탕의 위치를 변경
    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = temp;
    }

    // 사탕 상자를 돌면서 가장 긴 연속된 사탕의 개수 찾기
    private static int check() {
        int checkMax = 1;

        // 2번의 루프문으로 스왑 후 현재위치에서 행과 열에 대해 연속된 사탕의 길이를 찾고
        // result 에 사탕의 길이의 최대값만 넣어줌

        // 현 위치 가로방향 진행
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {

                if (candy[i][j] == candy[i][j + 1]) {
                    cnt++;
                } else {
                    checkMax = Math.max(checkMax, cnt);
                    cnt = 1;
                }
            }
            checkMax = Math.max(checkMax, cnt);
        }

        // 현 위치 세로방향으로 진행
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candy[j][i] == candy[j + 1][i]) {
                    cnt++;
                } else {
                    checkMax = Math.max(checkMax, cnt);
                    cnt = 1;
                }
            }
            checkMax = Math.max(checkMax, cnt);
        }

        return checkMax;
    }

}