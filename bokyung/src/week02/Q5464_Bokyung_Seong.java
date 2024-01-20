import java.util.*;

//[ 효율성 ]
//- 메모리: 25496kb
//- 시간: 344ms
public class Q5464_Bokyung_Seong {
    static int[] isParking;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int answer = 0;

        //주차 대기줄
        Queue<Integer> line = new LinkedList<>();

        //주차공간 별 주차 여부
        isParking = new int[n+1];

        //주차공간 별 단위무게 당 요금
        int[] price = new int[n+1];
        for(int i = 1; i <= n; i++){
            price[i] = sc.nextInt();
        }

        //차량 별 무게
        int[] carWeight = new int[m+1];
        for(int i = 1; i <= m; i++){
            carWeight[i] = sc.nextInt();
        }

        for(int i = 0; i < 2 * m; i++){
            int carNum = sc.nextInt();

            //입차
            if(carNum > 0) {
                int space = checkSpace();

                //빈 자리 없을 때
                if(space == 0) line.offer(carNum);
                //빈 자리 있을 때
                else isParking[space] = carNum;
            }
            //출차
            else{
                //양수로 만들어주기
                carNum *= -1;
                int space = checkSpace(carNum);
                answer += carWeight[carNum] * price[space];
                isParking[space] = line.isEmpty() ? 0 : line.poll();
            }
        }
        System.out.println(answer);
        sc.close();
    }

    public static int checkSpace(){
        for(int i = 1; i < isParking.length; i++){
            if(isParking[i] == 0) return i;
        }
        return 0;
    }

    public static int checkSpace(int carNum){
        for(int i = 1; i < isParking.length; i++){
            if(isParking[i] == carNum) return i;
        }
        return 0;
    }
}
