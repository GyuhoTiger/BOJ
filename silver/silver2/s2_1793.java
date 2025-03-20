package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class s2_1793 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        
        // 점화식 
        for (int i = 2; i <= 250; i++) {  
            dp[i] = dp[i - 2].multiply(BigInteger.valueOf(2));  
            dp[i] = dp[i].add(dp[i - 1]);  
        }

        String input;

        while((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
