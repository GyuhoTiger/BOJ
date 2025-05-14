package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_3182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int answer = 0;

        for(int i = 1; i < N + 1; i++) {
            boolean[] visit = new boolean[N + 1];

            int count = 0;
            int now = i;

            while (visit[now] == false) {
                visit[now] = true;
                count++;
                now = arr[now];
            }

            if (count > max) {
                max = count;
                answer = i; 
            }
        }

        System.out.println(answer);
        br.close();
    }
}