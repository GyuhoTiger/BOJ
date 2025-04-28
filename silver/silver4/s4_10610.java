package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s4_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int len = number.length();

        int[] array = new int[len];
        int sum = 0;

        for(int i = 0; i < len; i++) {
            array[i] = number.charAt(i) - '0';
            sum += array[i];
        }

        Arrays.sort(array);

        if (array[0] != 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        // 가장 큰 수를 출력해야하므로
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(array[i]);
        }

        System.out.println(sb);
        br.close();
    }
}