package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class s4_24465 {

    // 생일에 따른 별자리 구분
    public static String star(int month, int day) {
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "물병";
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "물고기";
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "양";
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "황소";
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) return "쌍둥이";
        else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) return "게";
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "사자";
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "처녀";
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "천칭";
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 22)) return "전갈";
        else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) return "사수";
        else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "염소";
        return "";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> member = new HashMap<>();
        
        // 7명의 멤버의 생일 입력
        for(int i = 0; i < 7; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            
            String constellation = star(month, day);
            member.put(constellation, 0); // 입력된 멤버의 생일별 별자리 입력
        }
        
        // 비교할 인원 N
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            String constellation = star(month, day);
            // 입력된 멤버의 별자리와 중복되는 별자리가 없으면 list에 월, 일 추가
            if(member.containsKey(constellation) == false) {
                list.add(new int[]{month, day});
            }
        }

        // 월 / 일 정렬
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]); // 같은 월인 경우 일을 비교
            }
            return Integer.compare(o1[0], o2[0]);
        });

        // 출력
        if (list.isEmpty()) {
            System.out.println("ALL FAILED");
        } else {
            for(int[] result : list) {
                System.out.println(result[0] + " " + result[1]);
            }
        }
        br.close();
    }
}
