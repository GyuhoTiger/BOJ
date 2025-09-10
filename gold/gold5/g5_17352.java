package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_17352 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int parent = find(1);
        sb.append(1).append(" ");
        for (int i = 1; i <= N; i++) {
            if (find(i)!= parent) {
                sb.append(i).append(" ");
                break;
            }
        }

        for (int i = 1; i <= N; i++){
            arr[i] = find(i);
        }

        System.out.println(sb);
        br.close();
    }


    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    static int find(int number){
        if (arr[number]  == number) {
            return number;
        }
        return arr[number] = find(arr[number]);
    }
}