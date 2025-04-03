package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class s4_9414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
             ArrayList<Integer> list = new ArrayList<>();
             while (true) {
                int cost = Integer.parseInt(br.readLine());
                if (cost == 0) {
                    break;
                }
                list.add(cost);
            }

            Collections.sort(list, Collections.reverseOrder());

            long price = 0;

            for (int j = 0; j < list.size(); j++) {
                price += 2 * Math.pow(list.get(j), j + 1); // 땅값 계산
                if (price > 5000000) {
                    System.out.println("Too expensive");
                    break;
                }
            }

            if (price <= 5000000) {
                System.out.println(price);
            }
        }

        br.close();
    }
}