package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class s4_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 명령의 수 N
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1: // push
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;

                case 2: // pop
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;

                case 3: // size
                    sb.append(stack.size()).append("\n");
                    break;

                case 4: // empty
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;

                case 5: // top
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}