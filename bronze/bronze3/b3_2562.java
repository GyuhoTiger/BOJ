package bronze.bronze3;

import java.util.Scanner;

public class b3_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int[] number = new int[10];
        int MAX = 0;
        int INDEX = 0;

        for(int i = 1; i <= 9; i++){
            number[i] = sc.nextInt();
            if(number[i] > MAX){
                MAX = number[i];
                INDEX = i;
            }
        }
        System.out.println(MAX);
        System.out.println(INDEX);

        sc.close();
    }
}
