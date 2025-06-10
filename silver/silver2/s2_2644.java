package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s2_2644 {
    static List<Integer>[] relation;
    static boolean[] visit;
    static int answer = -1; // 촌수를 찾지 못한 경우 -> -1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전체 사람의 수 N

        relation = new ArrayList[N + 1];
		visit = new boolean[N + 1];

        // 배열 리스트 초기화
		for(int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<>();
		}

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); 

        // 정점 - 간선 연결
        for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation[p].add(c);
			relation[c].add(p);
		}

        dfs(a, b, 0);

        System.out.println(answer);
        br.close();
    }

    public static void dfs(int start, int end, int count) {
        if (start == end) {
            answer = count;
            return;
        }
    
        visit[start] = true;
    
        for (int next : relation[start]) {
            if (!visit[next]) {
                dfs(next, end, count + 1);
            }
        }
    }
}