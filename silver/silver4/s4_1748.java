package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브루트포스 알고리즘
public class s4_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int length = 10; // 처음 자릿수 변경 수
        int count = 1; // 자릿수 길이
        int answer = 0; //새로운 수의 자릿수

        for (int i = 1; i <= N; i++) {
			if (i % length == 0) {
				count++;
				length *= 10;
			}
			answer += count;
		}
        System.out.println(answer);
        br.close();
    }
}
