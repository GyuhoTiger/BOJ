package bronze.bronze5;

import java.util.Scanner;

public class b5_28444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        int[] arr = new int[5];

        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }

        result = arr[0] * arr[1] - arr[2] * arr[3] * arr[4];

        System.out.println(result);
        sc.close();
    }
}
