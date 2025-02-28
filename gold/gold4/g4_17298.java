package gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택
public class g4_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 숫자가 스택의 가장 위 인덱스의 숫자보다 큰 경우
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i]; // 오큰수 저장
            }
            stack.push(i); // 오큰수가 없는 인덱스가 스택에 push
        }

        // 스택에 push 되어있는 인덱스들은 오큰수가 없는 숫자 -> -1 저장
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
