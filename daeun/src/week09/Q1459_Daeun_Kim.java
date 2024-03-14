import java.util.Scanner;

public class Q1459_Daeun_Kim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long w = sc.nextInt(); // 걸어서 한 블록 가는데 걸리는 시간
        long s = sc.nextInt(); // 대각석으로 한 블록 가로지르는 시간
        long min = Math.min(x, y);
        long max = Math.max(x, y);
        long cal1;
        long cal2 = Math.min(((x+y) * w), min*s + (max-min)*w);
        if ((x+y) % 2 == 0) {
            cal1 = max*s;
        } else {
            cal1 = w + (max-1)*s;
        }
        System.out.println(Math.min(cal1, cal2));
    }
}
