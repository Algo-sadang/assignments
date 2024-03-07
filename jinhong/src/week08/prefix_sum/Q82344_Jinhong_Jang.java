package week08.prefix_sum;

public class Q82344_Jinhong_Jang {
    /**
     * programmers
     * */
    public int solution(int[][] board, int[][] skill) {
        int re = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];

        for(int[] s : skill) {
            int t = s[0];
            int r1 = s[1], r2 = s[3];
            int c1 = s[2], c2 = s[4];

            int d = (t == 1) ? -s[5] : s[5];
            for(int i = r1; i <= r2; i++) {
                sum[i][c1] += d;
                sum[i][c2+1] -= d;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j != 0)
                    sum[i][j] += sum[i][j-1];
                board[i][j] += sum[i][j];
                if(board[i][j] > 0)
                    re++;
            }
        }

        return re;
    }
}