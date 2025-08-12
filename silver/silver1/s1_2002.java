package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class s1_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 차의 대수 N

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arr[i] = map.get(input);
        }

        int count = 0;
        for (int i = 0; i< N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}