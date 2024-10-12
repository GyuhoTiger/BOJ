package bronze.bronze5;

import java.util.Scanner;

public class b5_3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] input = new int[6];

        for(int i = 0; i < 6; i++){
            input[i] = sc.nextInt();
            input[i] = chess[i] - input[i];
            System.out.print(input[i] + " ");
        }
        sc.close();
    }
}
