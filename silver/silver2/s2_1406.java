package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택
public class s2_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<Character>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stackOne.push(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String command = br.readLine();

            char c = command.charAt(0);
            switch(c) {
                case 'L':
                    if(!stackOne.isEmpty())
                        stackTwo.push(stackOne.pop());

                    break;
                case 'D':
                    if(!stackTwo.isEmpty())
                        stackOne.push(stackTwo.pop());

                    break;
                case 'B':
                    if(!stackOne.isEmpty()) {
                        stackOne.pop();
                    }
                    break;
                case 'P':
                    char s = command.charAt(2);
                    stackOne.push(s);
                    break;
                default:
                    break;
            }
        }

        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        while (!stackTwo.isEmpty()) {
            sb.append(stackTwo.pop());
        }
        
        System.out.println(sb);
        br.close();
    }
}
