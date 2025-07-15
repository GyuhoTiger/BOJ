package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken()); // 신호등 개수 N
        int L = Integer.parseInt(st.nextToken()); // 도로 길이 L

        int position = 0; // 현재 위치
        int time = 0; // 시간
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken()); // 신호등 위치 D
            int R = Integer.parseInt(st.nextToken()); // 빨간불
            int G = Integer.parseInt(st.nextToken()); // 초록불
 
            time += (D - position);
            position = D;
 
            int section = time %  (R + G);

            if (section < R) {
                time += R - section;
            }        
        }
 
        time += (L - position);

        System.out.println(time);
        br.close();
    }
}