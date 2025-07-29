package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_14713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<String>[] q = new LinkedList[101];
		for (int i = 0; i <= 100; i++) {
			q[i] = new LinkedList<String>();
		}

        int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String[] word = br.readLine().split(" ");
	
			for (int j = 0; j < word.length; j++) {
				q[i].add(word[j]);
			}
		}

        // 사람이 들은 전체 문장
        String[] sentence = br.readLine().split(" ");

        // 앵무새들 중 이 단어가 맨 앞에 있는지 확인
        for (int i = 0; i < sentence.length; i++) {
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if(!q[j].isEmpty() && q[j].peek().equals(sentence[i])) {
					q[j].poll();
					flag = true;
					break;
				}
            }

            // 단어를 말할 앵무새가 없으면 불가능
            if (!flag) {
                System.out.println("Impossible");
				return;
			}
        }

        // 큐가 비어있는지 확인
        for (int i = 0; i < N; i++) {
            if (!q[i].isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
        br.close();
    }
}