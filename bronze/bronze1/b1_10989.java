package bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카운팅 정렬 이용
public class b1_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < 10001; i++){
            while(count[i] > 0){
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        System.out.println(sb);
        br.close();
    }
}