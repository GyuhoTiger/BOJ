package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그리디 알고리즘
public class s3_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 식탁 길이
        int K = Integer.parseInt(st.nextToken()); // 햄버거 거리
        String s = br.readLine();

        char[] arr = new char[N];
        boolean[] eat = new boolean[N]; // 햅머거 먹었는지 체크
        for(int i = 0; i < N; i++){
            arr[i] = s.charAt(i);
        }

        int count = 0; // 햄버거 먹은 사람 수

        for(int i = 0; i < N; i++){
            if(arr[i] == 'P') {
                for(int j = (i - K); j < (i + K + 1); j++){ //거리 K 만큼 탐색
                    if(j >= 0 && j < N && arr[j] == 'H' && !eat[j]) {
                        eat[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
