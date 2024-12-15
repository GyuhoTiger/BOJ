package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Stack
public class s4_3986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<Character>();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            for(int j = 0; j < word.length(); j++) {
                if(!stack.isEmpty() && word.charAt(j) == stack.peek()) { // 맨 위 단어와 비교교
                    stack.pop();
                } else {
                    stack.push(word.charAt(j)); 
                }
            }
            if(stack.isEmpty()) {
			    count++;
            }
            stack.clear();
        }
        System.out.println(count);
        br.close();
    }
}
