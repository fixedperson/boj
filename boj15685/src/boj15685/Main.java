package boj15685;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[101][101];

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(x,y,d,g);
        }

        int answer = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
                    answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dragonCurve(int x, int y, int d, int g){
        // 커브의 방향 정하기
        List<Integer> list = new ArrayList<>();
        list.add(d);
        for(int i = 1; i <= g; i++){
            for(int j = list.size()-1; j >= 0; j--){
                int temp = list.get(j);

                if(temp == 3)
                    list.add(0);
                else
                    list.add(temp + 1);
            }
        }

        // 드래곤이 이동한 경로
        int x1 = x;
        int y1 = y;
        map[x1][y1] = 1;
        for (int dir : list) {
            if (dir == 0) {
                x1++;
            } else if (dir == 1) {
                y1--;
            } else if (dir == 2) {
                x1--;
            } else {
                y1++;
            }
            map[x1][y1] = 1;
        }
    }
}
