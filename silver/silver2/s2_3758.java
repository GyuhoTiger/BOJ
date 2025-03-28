package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s2_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 데이터의 수 T

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수 n
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수 k
            int t = Integer.parseInt(st.nextToken()); // 팀의 ID t
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수 m


            int[][] highScore = new int[n + 1][k + 1]; // 각 팀의 문제별 최고 점수
            int[] totalScore = new int[n + 1]; // 팀별 총점
            int[] submitCount = new int[n + 1]; // 팀별 제출 횟수
            int[] time = new int[n + 1]; // 팀별 마지막 제출 시간

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
            
                if (highScore[id][problem] < score) {
                    totalScore[id] += score - highScore[id][problem]; // 점수 차이만큼 반영
                    highScore[id][problem] = score;
                }
                submitCount[id]++;
                time[id] = j;
            }

            List<Integer> rank = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                rank.add(j);
            }

            rank.sort((a, b) -> {
                if (totalScore[a] != totalScore[b]) return totalScore[b] - totalScore[a]; // 팀별 총점 내림차순
                if (submitCount[a] != submitCount[b]) return submitCount[a] - submitCount[b]; // 팀별 제출 횟수 오름차순
                return time[a] - time[b]; // 마지막 제출 시간 오름차순
            });

            // 팀 순위 찾기
            for (int j = 0; j < rank.size(); j++) {
                if (rank.get(j) == t) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
