package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2493_Bokyung_Seong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력용
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        String[] s = br.readLine().split(" ");

        //탑의 번호가 배열 index, 배열의 값이 탑의 높이
        int[] tops = new int[n+1];

        for(int i = 1; i <= n; i++){
            tops[i] = Integer.parseInt(s[i-1]);
            while(!st.isEmpty()){
                if(tops[st.peek()] < tops[i]){
                    st.pop();
                }else if(tops[st.peek()] >= tops[i]){
                    sb.append(st.peek()).append(" ");
                    st.push(i);
                    break;
                }
            }
            if(st.isEmpty()){
                st.push(i);
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
        br.close();
    }
}
