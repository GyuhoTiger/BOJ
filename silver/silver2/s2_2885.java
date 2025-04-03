package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 상근이가 필요한 초콜릿 개수 K
        
        int size = 1;
        int count = 0;

        while(size < K) {
            size *= 2;
        }

        System.out.println(size + " ");

        while(K > 0) {
            if(K >= size) {
                K -= size;
            } else {
                size /= 2;
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}