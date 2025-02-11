package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		int[] alphabet = new int[26];
		int index = 0;
		int odd = 0;
		int number = 0;

        String st = br.readLine();

		for(int i = 0; i < st.length(); i++) {
			index = (st.charAt(i) - 'A');
			alphabet[index]++;
		}

		// 알파벳 홀수 판별
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 != 0) {
                odd++;
                number = i;
            }
			// 홀수가 아닌게 2개 이상이면 팰린드롬 불가
            if (odd > 1) {
                System.out.print("I'm Sorry Hansoo");
                return;
            }
        }

		// String 앞부분 반
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < (alphabet[i] / 2); j++) {
                sb.append((char)(i + 'A'));
            }
        }

        String answer = sb.toString();

		// odd가 1일 때 가운데 문자
        if (odd == 1) {
            answer += (char) (number + 'A');
        }

		// 뒷부분 반 StringBuilder reverse 사용
        answer += sb.reverse().toString();
        System.out.println(answer);
		br.close();
	}
}
