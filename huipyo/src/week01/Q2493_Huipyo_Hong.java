package week01;

import java.util.*;
import java.util.stream.Collectors;

public class Q2493_Huipyo_Hong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>() { { for (int i = 0; i < n; i++) add(scanner.nextInt()); } };
        int[] array = new int[n];

        for (int i = 1; i < n; i++) {
            array[i] = findHighNumber(i, list, array);
        }
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        scanner.close();
    }

    private static int findHighNumber(int index, List<Integer> list, int[] array) {
        int position = index - 1;

        while (position >= 0 && list.get(index) > list.get(position)) {
            position = array[position] - 1;
        }
        return position + 1;
    }
}
