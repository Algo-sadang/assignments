import java.util.*;

//[ 효율성 ]
//- 메모리: 23048KB
//- 시간: 308ms

public class Q29813_Bokyung_Seong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>(){
            {
                for(int i = 0; i < n; i++){
                    String s = sc.next();
                    offer(s);
                    map.put(s, sc.nextInt());
                }
            }
        };

        while(q.size() > 1){
            String s = q.poll();
            int num = map.get(s);

            for(int i = 0; i < (num -1) % q.size(); i++){
                q.offer(q.poll());
            }
            q.poll();
        }

        System.out.println(q.poll());
    }
}
