package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class s2_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int number = 1;
        boolean check = true;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (number <= target) {
                stack.push(number++);
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                check = false;
                break;
            }
        }

        if (check == true) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }

        br.close();
    }
}