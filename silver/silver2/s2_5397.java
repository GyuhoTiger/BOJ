package silver.silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class s2_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 시간초과로 인해 BufferedWriter 사용

        Stack<Character> stack = new Stack<>(); // 입력받는 디폴트 스택
        Stack<Character> arrow = new Stack<>(); // 화살표 입력시 옮겨주는 스택

        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < N; i++) {
            String password = br.readLine();
            int len = password.length();
            for(int j = 0; j < len; j++) {
                char c = password.charAt(j);
                switch (c) {
                    case '<' :
                        if(!stack.isEmpty()) {
                            // stack에서 pop한 문자를 arrow에 옮겨둠
                            arrow.push(stack.pop()); 
                        }
                        break;
                    // 
                    case '>' : 
                        if(!arrow.isEmpty()) {
                            // arrow에 옮겨둔 문자를 stack에 Push
                            stack.push(arrow.pop()); 
                        }
                        break;
                    case '-' :
                        if(!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                    default : 
                        stack.push(c);
                        break;
                }
            }
            while(!arrow.isEmpty()) {
				stack.push(arrow.pop());
			}
            for(int j = 0; j < stack.size(); j++) {
                bw.write(stack.get(j));
            }
            bw.write("\n");
            stack.clear();
            arrow.clear();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
