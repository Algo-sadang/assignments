/**
 사탕 게임
 https://www.acmicpc.net/problem/3085
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

    private static int getLongestContinuousCount(String[][] candies, boolean isCheckRow) {
        int result = 0;

        for (int i = 0; i < candies.length; ++i) {
            int count = 1;

            for (int j = 0; j < candies[i].length - 1; ++j) {
                String first = isCheckRow ? candies[i][j] : candies[j][i];
                String last = isCheckRow ? candies[i][j + 1] : candies[j + 1][i];

                if (!first.equals(last)) {
                    count = 1;
                } else {
                    count++;
                }
            }
            result = Math.max(result, count);
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
