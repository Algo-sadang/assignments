package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tower {
    int index;
    int height;

    Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Q2493_Daeun_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().height <= top) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(stack.peek().index).append(" ");
            } else {
                sb.append("0 ");
            }
            stack.push(new Tower(i, top));
        }
        System.out.println(sb);
    }
}
