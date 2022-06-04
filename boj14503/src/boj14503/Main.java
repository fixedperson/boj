package boj14503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int r, c, d;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r,c,d);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void clean(int x, int y, int direction){
        if(map[x][y] == 0){
            map[x][y] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(map[nx][ny] == 0){
                clean(nx,ny,direction);
                return;
            }
        }

        int back = (direction + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if(map[bx][by] != 1) {
            clean(bx, by, direction);
        }
    }
}