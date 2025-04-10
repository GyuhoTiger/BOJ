package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class s4_1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String>[] arr = new ArrayList[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            arr[i] = new ArrayList<>();
            

            for (int j = 0; j< word.length(); j++){
                arr[i].add(word.substring(j) + word.substring(0, j));
            }

            boolean check = true;

            for (int k = 0; k < i; k++) {
                for (String cycle : arr[k]) {
                    if (cycle.equals(word)) {
                        check = false;
                        break;
                    }
                }

                if (check == false) {
                    break;
                }
            }

            if (check == true) {
                result++;
            } 
        }

        System.out.println(result);
        br.close();
    }
}