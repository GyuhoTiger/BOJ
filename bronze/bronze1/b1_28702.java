package bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = 0;
        boolean flag = false;

        for(int i = 0; i < 3; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            
            // 숫자면 플래그 변경, number 증가
            if(c != 'F' && c != 'B') {
                number = Integer.parseInt(str);
                flag = true;
            }
            if(flag == true) {
                number++;
            }
        }

        if(number % 3 == 0) {
            if(number % 5==0) {
                // FizzBuzz
                System.out.println("FizzBuzz");
            }
            else {
                // Fizz
                System.out.println("Fizz");
            }
        }
        else{
            if(number % 5 == 0) {
                // Buzz
                System.out.println("Buzz");
            }
            else {
                // i
                System.out.println(number);
            }
        }
        br.close();
    }
}
