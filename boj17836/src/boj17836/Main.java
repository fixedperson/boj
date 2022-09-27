package boj17836;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M][2];

        int answer = bfs();

        bw.write((answer == -1 ? "Fail" : answer) + "\n");

        bw.close();
        br.close();
    }
    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new Node(0, 0, 0, false));

        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.time > T) break;

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;

                if(nx == N-1 && ny == M-1) return temp.time+1;
                if(map[nx][ny] == 2){
                    q.add(new Node(nx, ny, temp.time+1, true));
                    visited[nx][ny][0] = true;
                    visited[nx][ny][1] = true;
                }

                else if(temp.sword){
                    if(visited[nx][ny][1]) continue;

                    q.add(new Node(nx, ny, temp.time + 1, true));
                    visited[nx][ny][1] = true;
                }

                else {
                    if(visited[nx][ny][0]) continue;
                    if(map[nx][ny] == 1) continue;

                    q.add(new Node(nx, ny, temp.time+1, false));
                    visited[nx][ny][0] = true;
                }
            }
        }

        return -1;
    }
    static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
class Node{
    int x, y, time;
    boolean sword;

    Node(int x, int y,int time, boolean sword){
        this.x = x;
        this.y = y;
        this.time = time;
        this.sword = sword;
    }
}
