package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if(input == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();

            int index = 0;

            for(int i = 0; i < t.length(); i++) {
                if(s.charAt(index) == t.charAt(i)) {
                    index++;
                }
                if(index == s.length()) {
                    break;
                }
            }

            if(index == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        br.close();
    }
}
