package P2024_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P_92344 {
    public static void main(String[] args) {
        int[][] board = {
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5}
        };
        int[][] skill = {
                {1,0,0,3,4,4},
                {1,2,0,2,3,2},
                {2,1,0,3,1,2},
                {1,0,1,3,3,1}
        };
        Solution92344 so = new Solution92344();
        System.out.println(so.afterRefactoring(board,skill));
        System.out.println(so.beforeRefactoring(board, skill));
    }
}
class Solution92344 {
    public int beforeRefactoring(int[][] board, int[][] skill) {
        for (int i = 0; i < skill.length; i++) {
            if(skill[i][0] == 1) {
                for (int j = skill[i][1]; j <= skill[i][3]; j++) {
                    for (int k = skill[i][2]; k <= skill[i][4]; k++) {
                        board[j][k] -= skill[i][5];
                    }
                }
            } else {
                for (int j = skill[i][1]; j <= skill[i][3]; j++) {
                    for (int k = skill[i][2]; k <= skill[i][4]; k++) {
                        board[j][k] += skill[i][5];
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }
    public int afterRefactoring(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] effect = new int[n + 1][m + 1];
        // 스킬
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            degree = type == 1 ? -degree : degree;

            effect[r1][c1] += degree;
            effect[r1][c2 + 1] -= degree;
            effect[r2 + 1][c1] -= degree;
            effect[r2 + 1][c2 + 1] += degree;
        }
        // 가로
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                effect[i][j] += effect[i][j - 1];
            }
        }
        // 세로
        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                effect[i][j] += effect[i - 1][j];
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += effect[i][j];
                if (board[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }
}