package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// M과 N의 최소공배수를 구해서 유효한 <x : y> 찾기
public class s1_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = LCM(M, N);
            int answer = -1;

            for (int j = x; j <= lcm; j += M) {
                int year = j % N;
                if (year == 0) {
                    year = N;
                }

                if (year == y) {
                    answer = j;
                    break;
                }
            }
            System.out.println(answer);
        }
        br.close();
    }

    // 최소공배수 (LCM)
    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    // 최대공약수 (GCD)
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}