package P2024_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2805 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> trees = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(sc.nextInt());
                }
            }
        };
        int start = 0;
        int end = Collections.max(trees);
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = trees.stream().filter(tree -> tree > mid).mapToLong(tree -> tree - mid).sum();

            if (sum >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

//        int max = list.stream().mapToInt(Integer::intValue).max().orElse(0);
//        Collections.sort(list);
//        int max = list.get(list.size() - 1);
//        while(true) {
//            int tree = 0;
//            max--;
//
//            for(int treeLength : list) {
//                if(treeLength > max) {
//                    tree += treeLength - max;
//                }
//            }
//            if(tree >= m) {
//                System.out.println(max);
//                break;
//            }
//        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        sc.close();
    }
}
