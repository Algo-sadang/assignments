import java.util.Arrays;
import java.util.Scanner;

public class Q2805_Daeun_Kim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long answer = 0;
        long[] trees = new long[n];
        for (int i=0; i<n; i++) {
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);
        long start = 1;
        long end = trees[n-1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long woodLen = 0;
            for (int i=0; i<n; i++) {
                long wood = trees[i] - mid;
                if (wood > 0) {
                    woodLen += wood;
                }
            }
            if (woodLen < m) {
                end = mid-1;
            }
            else {
                answer = mid;
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
