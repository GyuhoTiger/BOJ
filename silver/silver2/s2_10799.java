package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택
public class s2_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String pipe = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < pipe.length(); i++) {
            char now = pipe.charAt(i);

            if (now == '(') {
                stack.push(now);
            } else {
                stack.pop();
                if (pipe.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}