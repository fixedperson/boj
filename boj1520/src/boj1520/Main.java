package boj1520;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static Integer[][] dp;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new Integer[M][N];

        bw.write(dfs(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int dfs(int x, int y){
        if(x == M - 1 && y == N - 1){
            return 1;
        }

        if(dp[x][y] != null){
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

            if(map[x][y] <= map[nx][ny]) continue;

            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }
}
