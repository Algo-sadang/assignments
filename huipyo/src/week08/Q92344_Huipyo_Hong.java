package week08;

public class Q92344_Huipyo_Hong {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][] {
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5}
        }, new int[][] {
                {1,0,0,3,4,4},
                {1,2,0,2,3,2},
                {2,1,0,3,1,2},
                {1,0,1,3,3,1}
        }));
        System.out.println(new Solution().solution(new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }, new int[][] {
                {1,1,1,2,2,4},
                {1,0,0,1,1,2},
                {2,2,0,2,0,100}
        }));
    }
}

/*class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int[] array : skill) {
            for (int i = array[1]; i <= array[3]; i++) {
                for (int j = array[2]; j <= array[4]; j++) {
                    board[i][j] += array[5] * (array[0] == 1 ? -1 : 1);
                }
            }
        }
        for (int[] array : board) {
            for (int num : array) {
                if (num > 0) answer++;
            }
        }
        return answer;
    }
}*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefixSums = new int[board.length + 1][board[0].length + 1];
        int answer = 0;

        for (int[] array : skill) {
            prefixSums[array[1]][array[2]] += array[5] * (array[0] == 1 ? -1 : 1);
            prefixSums[array[3] + 1][array[4] + 1] += array[5] * (array[0] == 1 ? -1 : 1);
            prefixSums[array[1]][array[4] + 1] += array[5] * (array[0] == 1 ? 1 : -1);
            prefixSums[array[3] + 1][array[2]] += array[5] * (array[0] == 1 ? 1 : -1);
        }
        for (int i = 1; i < prefixSums.length; i++) {
            for (int j = 0; j < prefixSums[i].length; j++) {
                prefixSums[i][j] += prefixSums[i - 1][j];
            }
        }
        for (int i = 1; i < prefixSums[0].length; i++) {
            for (int j = 0; j < prefixSums.length; j++) {
                prefixSums[j][i] += prefixSums[j][i - 1];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + prefixSums[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}