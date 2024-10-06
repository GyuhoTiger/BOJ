package bronze.bronze5;

import java.util.Scanner;

public class b5_11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int ASCII = (int)str.charAt(0); // int ASCII = sc.next().charAt(0) 으로 대체가능

        System.out.print(ASCII);
        sc.close();
    }
}
