package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s4_1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        int minNumber = 5;
        // 5 6 7
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] - arr[i] < 5) {
                    count++;
                } else {
                    break;
                }
            }
            minNumber = Math.min(minNumber, 5 - count);
        }
        System.out.println(minNumber);
        br.close();
    }
}