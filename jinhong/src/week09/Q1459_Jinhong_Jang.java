package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1459_Jinhong_Jang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long x = Long.parseLong(st.nextToken());
        Long y = Long.parseLong(st.nextToken());
        Long w = Long.parseLong(st.nextToken()); //직선
        Long s = Long.parseLong(st.nextToken()); //대각선

        Long[] time = new Long[3];
        time[0] = (x + y) * w;
        time[1] = ((x + y) % 2 == 0) ? Math.max(x, y) * s : (Math.max(x, y) - 1) * s + w;
        time[2] = (Math.min(x, y) * s) + ((Math.max(x, y) - Math.min(x, y)) * w);

        Arrays.sort(time);
        System.out.println(time[0]);
    }
}
