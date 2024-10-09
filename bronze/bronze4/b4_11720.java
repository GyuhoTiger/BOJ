package bronze.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int arr[] = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++){
            arr[i] = number.charAt(i) - '0';
            answer += arr[i];
        }

        System.out.print(answer);
        br.close();
    }
}
