package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_2725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1001];
        int tmp;
        // N = 1일 때, (0,0), (1,0), (0,1)
        arr[1] = 3;

        for (int i = 2; i < 1001; i++) {
            tmp = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    tmp++;
                }
            }
            arr[i] = arr[i - 1] + (tmp * 2);
         }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++){
            sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
     }
}