package bronze.bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class b2_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if(input.equals("1 2 3 4 5 6 7 8"))
            System.out.println("ascending");
        else if(input.equals("8 7 6 5 4 3 2 1"))
            System.out.println("descending");
        else
            System.out.println("mixed");
        br.close();
    }
}
