package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class s3_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 피연산자 개수 N
        String input = br.readLine();

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            switch (c) {
                case '+': {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case '-': {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                }
                case '*': {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case '/': {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                }
                default: {
                    int idx = c - 'A';
                    stack.push((double) arr[idx]);
                }
            }
        }

        double answer = stack.pop();
        System.out.printf("%.2f\n", answer);
        br.close();
    }
}