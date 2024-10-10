package silver.silver4;

import java.util.Scanner;

public class s4_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        while(N > 0){
            if(N % 5 == 0){
                count += (N / 5);
                break;
            }
            else{
                N -= 3;
                count++;
            }
            if(N < 0) count = -1;
        }
        System.out.println(count);
        sc.close();
    }
}
