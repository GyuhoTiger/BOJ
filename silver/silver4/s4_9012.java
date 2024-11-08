package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class s4_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
			String str = br.readLine();
			int len = str.length();

			Stack<Character> stack = new Stack<Character>();
			
			for(int j = 0; j < len; j++) {
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				}else {
					if(stack.empty()) {
						stack.push(str.charAt(j));
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
        br.close();
	}
}