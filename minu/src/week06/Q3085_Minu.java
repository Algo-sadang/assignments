package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import static java.util.Collections.swap;

public class Q3085_Minu {

    private static int N, result;
    private static char[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];
        result = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                candy[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                check();
                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                check();
                swap(i, j, i + 1, j);
            }
        }

        System.out.println(result);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = temp;
    }

    private static void check() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candy[i][j] == candy[i][j + 1]) {
                    cnt++;
                } else {
                    result = Math.max(result, cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result, cnt);
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candy[j][i] == candy[j + 1][i]) {
                    cnt++;
                } else {
                    result = Math.max(result, cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result, cnt);
        }
    }

}