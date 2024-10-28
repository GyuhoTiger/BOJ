package bronze.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class b4_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String s = "";

        s = s + A;
        s = s + B;

        System.out.println(A + B - C);
        System.out.println(Integer.parseInt(s) - C);

        br.close();
    }
}
