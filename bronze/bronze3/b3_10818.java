package bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class b3_10818 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer strtk = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strtk.nextToken());
		}

        Arrays.sort(arr);
        System.out.print(arr[0] + " " + arr[N - 1]);
        br.close();
    }
}
