package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String doc = br.readLine();
        String word = br.readLine();

        String[] parts = doc.split(word, -1);
        int count = parts.length - 1;

        System.out.println(count);
        br.close();
    }
}
