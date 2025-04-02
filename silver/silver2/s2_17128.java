package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_17128 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());


        int[] cow = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = cow[i] * cow[(i + 1) % N] * cow[(i + 2) % N] * cow[(i + 3) % N];
            sum += arr[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int change = Integer.parseInt(st.nextToken()) - 1;

            cow[change] = -cow[change];

            for (int j = 0; j < 4; j++) {
                int index = (change - j + N) % N;
                sum -= arr[index];
                arr[index] = cow[index] * cow[(index + 1) % N] * cow[(index + 2) % N] * cow[(index + 3) % N];
                sum += arr[index];
            }

            System.out.println(sum);
        }

        br.close();
    }
}
