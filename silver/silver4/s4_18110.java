package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s4_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number[] = new int[N];
        int cut = (int)Math.round(N * 0.15); // 절사평균
        double sum = 0;

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);
        
        // 절사평균 제외 한 값들의 합
        for(int i = cut; i < (N - cut); i++) {
            sum += number[i];
        }

        int answer = (int)Math.round(sum / (N - cut * 2)); // 평균 계산
        System.out.println(answer);
        br.close();
    }
}
