package boj21610;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map; // 물의 양
    static Queue<Cloud> cloudsQueue = new LinkedList<>();
    static boolean[][] visited;
    static Queue<Move> movesQueue;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        movesQueue = new LinkedList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            movesQueue.add(new Move(d, s));
        }

        cloudsQueue.add(new Cloud(N-1, 0));
        cloudsQueue.add(new Cloud(N-1, 1));
        cloudsQueue.add(new Cloud(N-2, 0));
        cloudsQueue.add(new Cloud(N-2, 1));

        while(!movesQueue.isEmpty()){
            cloudMove();
            createCloud();
        }

        bw.write(sumWater() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void cloudMove() {
        Move temp = movesQueue.poll();
        visited = new boolean[N][N];

        Queue<Cloud> cheatQueue = new LinkedList<>();
        while(!cloudsQueue.isEmpty()){
            Cloud c = cloudsQueue.poll();

            int nx = c.x + (dx[temp.d] * temp.s);
            int ny = c.y + (dy[temp.d] * temp.s);

            while(!isValid(nx)) nx = change(nx);
            while(!isValid(ny)) ny = change(ny);

            rain(nx, ny);
            disappear(nx, ny);
            cheatQueue.add(new Cloud(nx, ny));
        }
        waterCopyCheat(cheatQueue);
    }
    static void rain(int x, int y) {
        map[x][y]++;
    }
    static void disappear(int x, int y) {
        visited[x][y] = true;
    }
    static void waterCopyCheat(Queue<Cloud> queue) {
        while(!queue.isEmpty()){
            Cloud c = queue.poll();

            int count = 0;
            for(int i = 1; i < 8; i += 2){
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];

                if(!isValid(nx) || !isValid(ny) || map[nx][ny] < 1) continue;

                count++;
            }
            map[c.x][c.y] += count;
        }
    }
    static void createCloud() {
        cloudsQueue.clear();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                if(map[i][j] >= 2){
                    map[i][j] -= 2;
                    cloudsQueue.add(new Cloud(i, j));
                }
            }
        }
    }
    static int sumWater() {
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer += map[i][j];
            }
        }
        return answer;
    }
    static boolean isValid(int x)
    {
        return x >= 0 && x < N;
    }
    static int change(int x)
    {
        return x < 0 ? x + N : x - N;
    }
}
class Cloud {
    int x;
    int y;
    Cloud(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Move{
    int d;
    int s;
    Move(int d, int s){
        this.d = d;
        this.s = s;
    }
}