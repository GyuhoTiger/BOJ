package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];

        for(int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        
        for(int i = (N - 1); i > 0; i--) {
			while(score[i] <= score[i - 1]) { // 현재 레벨과 이전 레벨 점수 비교
				count++;
				score[i - 1] = score[i - 1] - 1;
			}
		}

        System.out.println(count);
        br.close();
    }
}