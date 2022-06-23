package boj16927;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static long R;
    static int[][] arr;
    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < Math.min(N,M)/2; i++){
            rotate(i, (N-i*2)*2 + (M-i*2)*2 - 4);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void rotate(int index, int length){
        for(int i = 0; i < R%length; i++){
            int pre = arr[index][index];
            int temp;
            int dir = 0;
            int y = index;
            int x = index;
            while(dir < 4){
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if(ny < index || ny >= N - index || nx < index || nx >= M - index){
                    dir++;
                }
                else{
                    temp = arr[ny][nx];
                    arr[ny][nx] = pre;
                    pre = temp;
                    y = ny;
                    x = nx;
                }
            }
        }
    }
}
