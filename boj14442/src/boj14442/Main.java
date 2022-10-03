package boj14442;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][M+1][K+1];
        map = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, 0, 1));
        visited[1][1][0] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.x == N && temp.y == M) return temp.move;

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;

                if(map[nx][ny] == 1 && temp.wall < K){
                    if(visited[nx][ny][temp.wall+1]) continue;

                    queue.add(new Node(nx, ny, temp.wall+1, temp.move+1));
                    visited[nx][ny][temp.wall+1] = true;
                }

                else if(map[nx][ny] == 0){
                    if(visited[nx][ny][temp.wall]) continue;

                    queue.add(new Node(nx, ny, temp.wall, temp.move+1));
                    visited[nx][ny][temp.wall] = true;
                }
            }
        }

        return -1;
    }
    static boolean isValid(int x, int y){
        return x > 0 && x <= N && y > 0 && y <= M;
    }
}

class Node{
    int x, y, wall, move;
    Node(int x, int y, int wall, int move){
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.move = move;
    }
}