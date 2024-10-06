package bronze.bronze5;

import java.util.Scanner;

public class b5_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            else c = Character.toLowerCase(c);
            System.out.print(c);
        }
        sc.close();
    }
}
