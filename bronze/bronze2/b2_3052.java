package bronze.bronze2;

import java.util.Scanner;

public class b2_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[43];
        int count = 0;

        for(int i = 0; i < 10; i++){
            int number = sc.nextInt();
            arr[(number % 42)]++;
        }

        for(int i = 0; i < 43; i++){
            if(arr[i] != 0) count++;
        }

        System.out.println(count);
        sc.close();
    }
}
