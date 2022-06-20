package boj17144;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] temp; // 1초 후 더해질 미세먼지의 양
    static int cleaner = -1; // 공기청정기의 윗쪽 좌표
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (cleaner == -1 && map[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        while(T-- > 0){
            diffusion();
            clean();
        }

        int sum = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //확산
    static void diffusion(){

        //초기화
        for(int i = 0; i < R; i++){
            Arrays.fill(temp[i], 0);
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 0 || map[i][j] == -1) continue;

                for(int k = 0; k < 4; k++){
                    int y = i + dx[k];
                    int x = j + dy[k];
                    if(y < 0 || y >= R || x < 0 || x >= C) continue;
                    if(map[y][x] == -1) continue;

                    temp[y][x] += map[i][j] / 5;
                    temp[i][j] -= map[i][j] / 5;
                }
            }
        }

        // map + temp
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] += temp[i][j];
            }
        }
    }

    //공기청정기 작동
    static void clean(){

        //초기화
        for(int i = 0; i < R; i++){
            Arrays.fill(temp[i], 0);
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if (map[i][j] == -1) continue;
                if(j == 0){
                    if(i <= cleaner){
                        temp[i+1][j] = map[i][j];
                        map[i][j] = 0;
                    }
                    else {
                        temp[i-1][j] = map[i][j];
                        map[i][j] = 0;
                    }
                }

                else if(j == C-1 && i != 0 && i != R-1){
                    if(i <= cleaner){
                        temp[i-1][j] = map[i][j];
                        map[i][j] = 0;
                    }

                    else{
                        temp[i+1][j] = map[i][j];
                        map[i][j] = 0;
                    }
                }

                else if(i == 0 || i == R-1){
                    temp[i][j-1] = map[i][j];
                    map[i][j] = 0;
                }

                else if(i == cleaner || i == cleaner+1){
                    temp[i][j+1] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }

        // map + temp
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(j == 0 && (i == cleaner || i == cleaner+1)) continue;
                map[i][j] += temp[i][j];
            }
        }
    }
}
