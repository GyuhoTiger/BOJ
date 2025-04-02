package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_5874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        char[] arr = line.toCharArray();
        int count = 0;
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                if (arr[i] == '(') {
                    count++;
                } else {
                    sum += count;
                }
            }
        }
        
        System.out.println(sum);
        br.close();
    }
}
