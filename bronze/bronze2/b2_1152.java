package bronze.bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b2_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens()); // countTokens(): StringTokenizer의 남아있는 토큰의 개수 반환
        br.close();
    }
}
