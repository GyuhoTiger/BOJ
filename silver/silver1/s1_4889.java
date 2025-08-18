package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class s1_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 1;
        while (true) {
            String input = br.readLine();

            if (input.contains("-")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '{') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        count++;
                        stack.push('{');
                    }
                }
            }

            count += stack.size() / 2;

            System.out.println(testCase + ". " + count);
            testCase++;
        }
        br.close();
    }
}