package P2024_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class B_Top {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        for(int i=0; i<n; i++) {
            heights[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        for(int i=0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
//        List<Integer> towers = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            towers.add(sc.nextInt());
//        }
//
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            result.add(0);
//            for (int j = i - 1; j >= 0; j--) {
//                if (towers.get(j) > towers.get(i)) {
//                    result.set(i, j + 1);
//                    System.out.println(result);
//                    break;
//                }
//            }
//        }
    }
}
//