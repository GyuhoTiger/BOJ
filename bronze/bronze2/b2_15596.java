package bronze.bronze2;

// 제출 시 class명은 : Test
public class b2_15596 {
    long sum(int[] a) {
        long ans = 0;

        for(int i = 0; i < a.length; i++) {
			ans += a[i];
		}
		return ans;
    }
}
