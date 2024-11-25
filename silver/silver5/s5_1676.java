package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class s5_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        BigInteger fac = new BigInteger("1");

        for(int i = 1; i <= N; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }

        String s = fac.toString();

        for(int i = (s.length() - 1); i >= 0; i--){
            if(s.charAt(i) - '0' == 0){
                count++;
            } else { 
                break;
            }
        }
        br.close();
        System.out.println(count);
    }
}