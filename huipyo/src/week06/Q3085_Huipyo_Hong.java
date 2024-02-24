/**
 사탕 게임
 https://www.acmicpc.net/problem/3085
 */

/**
 *  [ 효율성 ]
 *  - 메모리: 18212KB
 *  - 시간 : 524ms
 */

package week06;

import java.util.*;

public class Q3085_Huipyo_Hong {
    static int mAnswer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] candies = new String[n][n];

        Arrays.setAll(candies, i -> {
            String[] input = scanner.next().split("");
            return input;
        });
        scanner.close();
//        System.out.println(Arrays.deepToString(candies));
        swap(candies, true);
        swap(candies, false);
        System.out.println(mAnswer);
    }

    // 민우님 check() 메소드 코드 참고
    private static int getLongestContinuousCount(String[][] candies) {
        int result = 0;

        for (String[] candy : candies) {
            int cnt = 1;
            
            for (int j = 0; j < candies.length - 1; j++) {
                if (candy[j].equals(candy[j + 1])) {
                    cnt++;
                } else {
                    result = Math.max(result, cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result, cnt);
        }
        for (int i = 0; i < candies.length; i++) {
            int cnt = 1;
            
            for (int j = 0; j < candies.length - 1; j++) {
                if (candies[j][i].equals(candies[j + 1][i])) {
                    cnt++;
                } else {
                    result = Math.max(result, cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result, cnt);
        }
        return result;
    }

    private static void swap(String[][] candies, boolean isCheckRow) {
        if (isCheckRow) {
            for (int i = 0; i < candies.length; i++) {
                for (int j = 0; j < candies[i].length - 1; j++) {
                    if (candies[i][j].equals(candies[i][j + 1])) continue;
                    else {
                        String temp = candies[i][j];
                        candies[i][j] = candies[i][j + 1];
                        candies[i][j + 1] = temp;
                        //getLong....
                        int rowResult = getLongestContinuousCount(candies, true);
                        int colResult = getLongestContinuousCount(candies, false);
                        mAnswer = Math.max(mAnswer, Math.max(rowResult, colResult));
                        temp = candies[i][j + 1];
                        candies[i][j + 1] = candies[i][j];
                        candies[i][j] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < candies[0].length; i++) {
                for (int j = 0; j < candies.length - 1; j++) {
                    if (candies[j][i].equals(candies[j + 1][i])) continue;
                    else {
                        String temp = candies[j][i];
                        candies[j][i] = candies[j + 1][i];
                        candies[j + 1][i] = temp;
                        //getLong....
                        int rowResult = getLongestContinuousCount(candies, true);
                        int colResult = getLongestContinuousCount(candies, false);
                        mAnswer = Math.max(mAnswer, Math.max(rowResult, colResult));
                        temp = candies[j + 1][i];
                        candies[j + 1][i] = candies[j][i];
                        candies[j][i] = temp;
                    }
                }
            }
        }
    }
}
