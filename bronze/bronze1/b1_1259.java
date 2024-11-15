package bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String number = br.readLine();
            int len = number.length();
            boolean check = true;
            if(number.equals("0")) {
                break;
            }
            for(int i = 0; i <= (len / 2); i++) {
                if(number.charAt(i) != number.charAt(len - i - 1)) {
                    check = false;
                }
            }
            if(check == true){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        br.close();
    }
}
