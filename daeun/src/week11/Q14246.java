import java.util.Arrays;
import java.util.Scanner;

public class Q14246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> sc.nextInt());
        long k = sc.nextLong();
        long answer = 0;
        int start = 0, end = 0;
        long sum = 0;
        while (end < n) {
            if (sum <= k) {
                sum += arr[end++];
            }
            while (sum > k) {
                answer += (n - end + 1);
                sum -= arr[start++];
            }
        }
        System.out.println(answer);
    }
}