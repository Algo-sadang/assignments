package P2024_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class B_14246 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        //split()은 정규 표현식을 사용하여 문자열 분리해서 느림
        //StringTokenizer 단순 문자만 분리해서 빠름
        Function<String, Integer> function = Integer::parseInt;
        //함수형 인터페이스

        int n = function.apply(token.nextToken());
        int[] arr = new int[n];
        token = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = function.apply(token.nextToken());
        }

        int k = function.apply(reader.readLine());

        int start = 0, end = 0;
        long sum = 0, result = 0;

        while(true) {
            if(sum > k) {
                result += n - end + 1;
                sum -= arr[start++];
            } else if(end >= n) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(result);
    }
}
