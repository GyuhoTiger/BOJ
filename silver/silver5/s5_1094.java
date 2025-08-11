package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine()); // 구하는 막대 길이 X

        int[] arr = { 64, 32, 16, 8, 4, 2, 1 };

        int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (X >= arr[i]) {
				count++;
				X -= arr[i];
			}
			if (X == 0) {
                break;
            }
        }
        System.out.println(count);
        br.close();
    }
}