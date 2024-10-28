package bronze.bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class b2_2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int count = 1; // 처음 시작
		int range = 2; // 범위
 
        if (N == 1) {
            System.out.println(1);
        } else {
            while (range <= N) {
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
         br.close();
	}
}
