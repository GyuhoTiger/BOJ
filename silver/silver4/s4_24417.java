package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_24417 {
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N) + " " + (N - 2)); // 재귀함수 호출횟수는 N - 2...

        br.close();
    }

    static int fibonacci(int n){
        int[] f  = new int[n + 1];

        f[1] = 1;
        f[2] = 1;
        
        for(int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
        }

        return f[n];
    }
}
