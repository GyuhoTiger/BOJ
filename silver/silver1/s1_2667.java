package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class s1_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N  && !visited[ny][nx] && map[ny][nx] == 1){
                dfs(nx, ny);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(j, i);
                    arr.add(count);
                }
            }
        }

        Collections.sort(arr);
        System.out.println(arr.size());

        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        br.close();
    }
}
