package gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class g4_16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Character> stack = new ArrayDeque<>();
	    char[] input = br.readLine().toCharArray();

		for (int i = 0; i < input.length; i++) {
			char ch = input[i];
			stack.addLast(ch);

			// 최근 4개의 문자가 PPAP이면 -> P로 변환
			if (stack.size() >= 4) {
				Character[] arr = new Character[4];
				for (int j = 3; j >= 0; j--) {
					arr[j] = stack.removeLast();
				}

                 // PPAP → P
				if (arr[0] == 'P' && arr[1] == 'P' && arr[2] == 'A' && arr[3] == 'P') {
					stack.addLast('P');

                // 패턴 안맞을 경우
				} else {
					for (int j = 0; j < 4; j++) {
						stack.addLast(arr[j]);
					}
				}
			}
		}

		// 스택에 P 하나만 남아있어야 PPAP 문자열
		if (stack.peekLast() == 'P' && stack.size() == 1) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}

        br.close();
    }
}