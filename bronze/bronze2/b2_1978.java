package bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(st.nextToken());
            for(int j = 2; j <= number; j++) {
				if(j == number) {
					count++;
				}
                else if(number % j == 0){
                    break;
                }
			}
        }
        System.out.println(count);
        br.close();
    }
}
