package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14246_Jinhong_Jang {
    /**
     *  [ 효율성 ]
     *  - 메모리: 21984 KB
     *  - 시간 : 272 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int start = 0, end = 0;  //i,j
        long cnt = 0, sum = 0;
        while(true) {
            if(sum > k) {
                cnt += n - end + 1;
                sum -= nums[start++];
            } else if(end == n) break;
            else {
                sum += nums[end++];
            }
        }

        System.out.println(cnt);
    }
}
