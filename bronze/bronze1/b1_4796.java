package bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_4796 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // L일 동안만 사용가능
            int P = Integer.parseInt(st.nextToken()); // 연속하는 P일 중
            int V = Integer.parseInt(st.nextToken()); // V일짜리 휴가 시작

            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            int answer = (V / P * L) + Math.min(L, (V % P));
            sb.append("Case ").append(count).append(": ").append(answer).append("\n");
            count++;
        }
        System.out.println(sb);
        br.close();
    }
}
