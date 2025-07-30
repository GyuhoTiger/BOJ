package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class s2_27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1: {
                    char c = st.nextToken().charAt(0);
                    deque.offerLast(c);
                    stack.offerLast(1);
                    break;
                }
                case 2: {
                    char c = st.nextToken().charAt(0);
                    deque.offerFirst(c);
                    stack.offerLast(2);
                    break;
                }
                case 3: {
                    if (!stack.isEmpty()) {
                        int top = stack.removeLast();
                        if (top == 1) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            sb.append('0');
        } else {
            for (char c : deque) sb.append(c);
        }
        System.out.print(sb);
        br.close();
    }
}