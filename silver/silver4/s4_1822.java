package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

// TreeSet
public class s4_1822 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken()); // 집합 A의 원소의 개수
        int nB = Integer.parseInt(st.nextToken()); // 집합 B의 원소의 개수

        TreeSet<Integer> tree = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nA; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nB; i++) {
            tree.remove(Integer.parseInt(st.nextToken()));
        }

        System.out.println(tree.size());
        for(int i = 0; i < nA; i++) {
            if(!tree.isEmpty()) {
                System.out.print(tree.pollFirst() + " "); // 작은 원소부터 출력
            }
        }
        br.close();
        // for-each 문 사용... for-each문 사용을 생활화하자
        // for(int i : tree) {
        //     System.out.print(i + " ");
        // }
    }
}