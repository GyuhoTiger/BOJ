package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체
public class s4_2960 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N + 1];
        int count = 0;

        // 2 ~ N까지 순회하며 지워지지않은 숫자 찾고 배수를 지워나간다
        for (int i = 2; i <= N; i++) {
            if (!check[i]) { // 소수인 경우
                for (int j = i; j <= N; j += i) {
                    if (!check[j]) {
                        check[j] = true;
                        count++;
                        if (count == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
        br.close();
    }   
}
