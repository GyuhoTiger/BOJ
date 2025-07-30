package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class s2_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (N --> 0) {
            String s = br.readLine();
            if (s.equals("0")) {
                if (minHeap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(minHeap.remove());
                }
            } else {
                minHeap.add(Integer.parseInt(s));
            }
        }
        br.close();
    }
}