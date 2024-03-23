package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무 자르기
 */
public class Q2805_Hyeonseon {
    /**
     * 메모리 119360 KB
     * 시간 536 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] forest = new int[N];
        int low = 0;
        int high = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < forest.length; i++) {
            forest[i] = Integer.parseInt(st.nextToken());
            high = high < forest[i] ? forest[i] : high;
        }

        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for(int tree : forest) {
                if(tree > mid) {
                    sum += (tree - mid);
                }
            }

            if(sum < M) {
                high = mid - 1;
            }
            else if(sum >= M){
                low = mid + 1;
            }
        }

        System.out.println(high);
    }
}
