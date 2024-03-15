class P192344_Daeun_Kim {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int m = board[0].length;
        int n = board.length;
        int[][] accArr = new int[n + 1][m + 1];
        
        for (int[] sk : skill) {
            int type = sk[0], r1 = sk[1], c1 = sk[2], r2 = sk[3], c2 = sk[4], degree = sk[5];
            if (type == 1) {
                degree *= -1;
            }
            accArr[r1][c1] += degree;
            accArr[r1][c2 + 1] -= degree;
            accArr[r2 + 1][c1] -= degree;
            accArr[r2 + 1][c2 + 1] += degree;
            
        }
        
        for (int i=0; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                accArr[i][j] += accArr[i][j-1];
            }
        }

        for (int j=0; j<m+1; j++) {
            for (int i=1; i<n+1; i++) {
                accArr[i][j] += accArr[i-1][j];
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (accArr[i][j] + board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}