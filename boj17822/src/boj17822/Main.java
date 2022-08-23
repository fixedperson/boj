package boj17822;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] num;
    static int totalSum;
    static int numCnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        num = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
                totalSum += num[i][j];
                numCnt += 1;
            }
        }

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            num = delete();
        }

        bw.write( totalSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void rotate(int x, int d, int k) {
        for(int i = x; i <= N; i += x){
            int[] temp = new int[M+1];
            for(int j = 1; j <= M; j++){
                int idx;

                if(d == 0) idx = j + k;
                else idx = j - k;

                if(!isValid(idx)) idx = change(idx);

                temp[idx] = num[i][j];
            }
            num[i] = temp;
        }
    }
    static int[][] delete() {
        int[][] temp = new int[N+1][M+1];

        boolean nothing = true;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(num[i][j] == 0) continue;

                boolean same = false;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(!isValid(ny)) ny = change(ny);

                    if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
                    if(num[nx][ny] == 0) continue;

                    if(num[i][j] == num[nx][ny]) same = true;
                }

                if(!same){
                    temp[i][j] = num[i][j];
                }
                else {
                    totalSum -= num[i][j];
                    numCnt -= 1;
                    nothing = false;
                }
            }
        }

        if(nothing){
            double avg = totalSum / (double) numCnt;

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    if(temp[i][j] == 0) continue;
                    if(temp[i][j] > avg){
                        temp[i][j]--;
                        totalSum--;
                    }
                    else if(temp[i][j] < avg){
                        temp[i][j]++;
                        totalSum++;
                    }
                }
            }
        }

        return temp;
    }
    static boolean isValid(int x) {
        return (x > 0) && (x <= M) ? true : false;
    }
    static int change(int x){
        return (x > M) ? x - M : x + M;
    }
}
