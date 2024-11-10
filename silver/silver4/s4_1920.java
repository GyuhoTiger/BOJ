package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int nArr[] = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        // nArr 배열정렬
        Arrays.sort(nArr);

        int M = Integer.parseInt(br.readLine());
        int mArr[] = new int[M];
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            // 존재하면 1, 존재하지 않으면 0을 StringBuilder에 추가
            if(Arrays.binarySearch(nArr, mArr[i]) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}
