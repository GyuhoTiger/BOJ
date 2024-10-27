package bronze.bronze5;

import java.util.Scanner;

public class b5_5522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for(int i = 0; i < 5; i++){
            sum += sc.nextInt();
        }
        System.out.print(sum);
        sc.close();
    }
}
