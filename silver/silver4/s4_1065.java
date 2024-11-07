package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= N; i++){
            // 두 자리수 이하일 경우는 무조건 등차수열
            if(i / 100 == 0){
                count++;
            // 세 자리수 일때는 각 자리수를 추출
            } else if (i / 1000 == 0) {
                int hund = i / 100;
                int ten = (i % 100) / 10;
                int one = i % 10;
            // 각 자리수 간 차이 비교
                if((hund - ten) == (ten - one))
                    count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}

