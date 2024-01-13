import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Q2841_Bokyung_Seong{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int ans = 0;
        Map<Integer, Stack<Integer>> guitar = new HashMap<>();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            //a번째 줄의 stack이 없으면, stack 생성 후 push b
            if(!guitar.containsKey(a)){
                guitar.put(a, new Stack<>());
            }
            //stack이 비었거나 peek이 b일 때 까지 반복
            while(guitar.get(a).isEmpty() || guitar.get(a).peek() != b){
                //stack이 비었거나, peek이 b보다 작으면 push b
                if(guitar.get(a).isEmpty() || guitar.get(a).peek() < b){
                    guitar.get(a).push(b);
                    ans++;
                }
                //peek이 b보다 크면 pop b
                else if(guitar.get(a).peek() > b){
                    guitar.get(a).pop();
                    ans++;
                }
            }
            //System.out.println(guitar.get(a));

        }
        System.out.println(ans);
        sc.close();
    }
}
