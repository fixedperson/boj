package boj20057;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    // 토네이도 이동
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 토네이도 X축 범위
    static int[][] tornadoX = {{0, -1, 1, -2, -1, 1, 2, -1, 1}, {2, 1, 1, 0, 0, 0, 0, -1, -1}, {0, 1, -1, 2, 1, -1, -2, 1, -1}, {-2, -1, -1, 0, 0, 0, 0, 1, 1}};
    // 토네이도 Y축 범위
    static int[][] tornadoY = {{-2, -1, -1, 0, 0, 0, 0, 1, 1}, {0, -1, 1, -2, -1, 1, 2, -1, 1}, {2, 1, 1, 0, 0, 0, 0, -1, -1}, {0, 1, -1, 2, 1, -1, -2, 1, -1}};
    static int[] sandAmount = {5, 10, 10, 2, 7, 7,  2, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(tornado() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int tornado() {
        int outSand = 0; // 밖으로 나가는 모래의 양

        // 토네이도의 현재 위치
        int x = N/2;
        int y = N/2;

        int dir = 0; // 방향
        int index = 1; // 이동 횟수
        // 이동 시작
        while(true) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < index; k++) {
                    // 토네이도의 다음 위치
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) return outSand;

                    int sand = map[nx][ny];
                    int spreadTotal = 0;
                    // 토네이도로 이동하는 모래
                    for (int i = 0; i < 9; i++) {

                        // 모래가 이동한 위치
                        int tx = nx + tornadoX[dir][i];
                        int ty = ny + tornadoY[dir][i];

                        int spreadSand = (map[nx][ny] * sandAmount[i]) / 100;
                        if(tx < 0 || tx >= N || ty < 0 || ty >= N){
                            outSand += spreadSand;
                        }
                        else {
                            map[tx][ty] += spreadSand;
                        }
                        spreadTotal += spreadSand;
                    }

                    // a의 위치
                    int ax = nx + dx[dir];
                    int ay = ny + dy[dir];
                    if (ax < 0 || ax >= N || ay < 0 || ay >= N) {
                        outSand += (sand-spreadTotal);
                    } else {
                        map[ax][ay] += (sand-spreadTotal);
                    }

                    map[nx][ny] = 0;
                    x = nx;
                    y = ny;
                }
                dir = (dir + 1) % 4;
            }
            index++;
        }
    }
}