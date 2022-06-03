package boj14499;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dice;
    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int N, M;
    static final int top = 0; // 1
    static final int bottom = 1; // 6
    static final int left = 2; // 4
    static final int right = 3; // 3
    static final int up = 4; // 5
    static final int down = 5; // 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dice = new int[6];
        for(int i = 0; i < N; i++){

        }

        map = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int move = Integer.parseInt(st.nextToken());

            int nx = x + dx[move - 1];
            int ny = y + dy[move - 1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            x = nx;
            y = ny;

            rollDice(move);

            if(map[nx][ny] == 0){
                map[nx][ny] = dice[bottom];
            }
            else{
                dice[bottom] = map[nx][ny];
                map[nx][ny] = 0;
            }

            bw.write(dice[top] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void rollDice(int move){
        int[] temp = dice.clone();

        if(move == 1){
            dice[top] = temp[left];
            dice[right] = temp[top];
            dice[bottom] = temp[right];
            dice[left] = temp[bottom];
        }

        else if(move == 2){
            dice[top] = temp[right];
            dice[right] = temp[bottom];
            dice[bottom] = temp[left];
            dice[left] = temp[top];
        }

        else if(move == 3){
            dice[top] = temp[up];
            dice[up] = temp[bottom];
            dice[bottom] = temp[down];
            dice[down] = temp[top];
        }

        else {
            dice[top] = temp[down];
            dice[down] = temp[bottom];
            dice[bottom] = temp[up];
            dice[up] = temp[top];
        }
    }
}
