package bronze.bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class b1_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
		double arr[] = new double[sc.nextInt()];
        double sum = 0;

		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
		}

		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
            sum += ((arr[i] / arr[arr.length - 1]) * 100);
		}

		System.out.print(sum / arr.length);      
        sc.close();
    }
}
