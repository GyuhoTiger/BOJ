package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 0) {
			System.out.println("SK");
        } else {
		    System.out.println("CY");
        }

        br.close();
    }
}
