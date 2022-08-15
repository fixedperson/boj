package boj20058;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int sum = 0, maxIce = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (Q-- > 0){
            int L = Integer.parseInt(st.nextToken());

            map = divide(L);
            map = reduceIce();
        }

        dfs();

        bw.write(sum + "\n" + maxIce);
        bw.flush();
        bw.close();
        br.close();
    }
    // 분할
    static int[][] divide(int L) {
        int[][] temp = new int[N][N];
        L = (int) Math.pow(2, L);
        for (int i = 0; i < N; i += L) {
            for (int j = 0; j < N; j += L) {
                rotate(i, j, L, temp);
            }
        }
        return temp;
    }
    // 회전
    static void rotate(int r, int c, int L, int[][] temp) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                temp[r + j][c + L - i - 1] = map[r + i][c + j];
            }
        }
    }
    // 얼음 감소
    static int[][] reduceIce() {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++)
            temp[i] = Arrays.copyOf(map[i], N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0) continue;
                // 얼음의 수
                int count = 0;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(map[nx][ny] > 0) count++;
                }

                if(count >= 3) continue;
                temp[i][j]--;
            }
        }

        return temp;
    }
    // 답 구하기
    static void dfs() {
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                sum += map[i][j];
                if(visited[i][j]) continue;
                if(map[i][j] == 0) continue;
                bfs(i, j);
            }
        }
    }
    static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Node(i, j));

        int count = 1;
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int k = 0; k < 4; k++){
                int nx = temp.x + dx[k];
                int ny = temp.y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                count++;
            }
        }

        maxIce = Math.max(maxIce, count);
    }
}

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}