package week08;

public class P_Q92344_Minu {

    public int solution(int[][] board, int[][] skill) {

        int result = 0;

        // 보드의 행과 열의 크기를 저장합니다.
        int N = board.length;
        int M = board[0].length;

        // 보드와 같은 크기의 배열을 생성하여 스킬 적용에 따른 변경 값을 저장합니다.
        int check[][] = new int[N + 1][M + 1];

        // 주어진 스킬 배열을 순회합니다.
        for (int i = 0; i < skill.length; i++) {
            // 스킬의 타입, 위치, 회전 각도를 가져옵니다.
            int type = skill[i][0];
            int r1 = skill[i][1], c1 = skill[i][2];
            int r2 = skill[i][3], c2 = skill[i][4];
            int degree = skill[i][5];

            // 파괴하는 스킬인 경우
            if (type == 1) {
                // 해당 영역의 값을 음수로 변경하여 파괴합니다.
                check[r1][c1] += -degree;
                check[r2 + 1][c1] += degree;
                check[r1][c2 + 1] += degree;
                check[r2 + 1][c2 + 1] += -degree;
            } else { // 복구하는 스킬인 경우
                // 해당 영역의 값을 양수로 변경하여 복구합니다.
                check[r1][c1] += degree;
                check[r2 + 1][c1] += -degree;
                check[r1][c2 + 1] += -degree;
                check[r2 + 1][c2 + 1] += degree;
            }
        }

        // 가로 누적합을 계산하여 check 배열을 업데이트합니다.
        for (int i = 0; i < N + 1; i++) {
            int sum = 0;
            for (int j = 0; j < M + 1; j++) {
                sum += check[i][j];
                check[i][j] = sum;
            }
        }

        // 세로 누적합을 계산하여 check 배열을 업데이트합니다.
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += check[j][i];
                check[j][i] = sum;
            }
        }

        // 변경된 보드와 원래의 보드의 값을 합산하여 양수인 경우에만 카운트합니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j] + board[i][j] > 0) result++;
            }
        }

        // 최종적으로 결과값을 반환합니다.
        return result;
    }

}