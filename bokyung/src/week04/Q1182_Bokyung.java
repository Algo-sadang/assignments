import java.util.*;

public class Q1182_Bokyung {
    static int mCount = 0;
    static int n, s;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        dfs(0,0);

        System.out.println(s == 0 ? mCount - 1 : mCount);
    }
    public static void dfs(int idx, int sum){
        if(idx == n){
            if(sum == s) {
                mCount++;
            }
            return;
        }
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}
