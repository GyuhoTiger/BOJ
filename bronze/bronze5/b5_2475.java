package bronze.bronze5;

import java.util.Scanner;

public class b5_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        int sum = 0;
        for(int i = 0; i < 5; i++){
            number = sc.nextInt();
            sum = sum + (number * number);
        }
        System.out.println((sum % 10));
        sc.close();
    }
}

