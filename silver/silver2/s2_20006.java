package silver.silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s2_20006 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<String[]>> rooms = new ArrayList<>(); // 방마다 (레벨, 닉네임)
        List<Integer> baseLevel = new ArrayList<>();    // 방장 레벨(기준 레벨)

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean join = false;

            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j).size() < m && Math.abs(baseLevel.get(j) - level) <= 10) {
                    rooms.get(j).add(new String[]{String.valueOf(level), name});
                    join = true;
                    break;
                }
            }

            if (join == false) {
                List<String[]> newRoom = new ArrayList<>();
                newRoom.add(new String[]{String.valueOf(level), name});
                rooms.add(newRoom);
                baseLevel.add(level);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            List<String[]> room = rooms.get(i);
            if (room.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            room.sort((a, b) -> a[1].compareTo(b[1])); // 닉네임 사전순 정렬
            for (String[] player : room) {
                sb.append(player[0]).append(" ").append(player[1]).append("\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}