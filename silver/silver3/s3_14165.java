package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class s3_14165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 걸그룹 수 N
		int M = Integer.parseInt(st.nextToken()); // 문제 수 M

        HashMap<String, String[]> group = new HashMap<String, String[]>();
		HashMap<String, String> member = new HashMap<String, String>();

        while (N --> 0) {
			String groupName = br.readLine();
			int K = Integer.parseInt(br.readLine());

			String[] arr = new String[K];

			while (K --> 0) {
				String memberName = br.readLine();
                arr[K] = memberName;
				member.put(memberName, groupName);
			}

			Arrays.sort(arr);
			group.put(groupName, arr);
		}

        StringBuilder sb = new StringBuilder();

        while (M-->0) {
			String question = br.readLine();
			int type = Integer.parseInt(br.readLine());

			switch (type) {
			    case 0 :
				    for (String name : group.get(question)) {
                        sb.append(name).append("\n");
                    }
				    break;
			    case 1 :
                    sb.append(member.get(question)).append("\n");
			}
		}

        System.out.println(sb);
        br.close();
    }
}