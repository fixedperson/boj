package boj14442;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[K+1][N+1][M+1];
        map = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        int answer = bfs();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.move == o2.move)
                    return o1.wall - o2.wall;
                return o1.move - o2.move;
            }
        });
        pq.add(new Node(1,1,0, 1));
        visited[0][1][1] = true;

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.y == N && temp.x == M)
                return temp.move;

            for(int i = 0; i < 4; i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];

                if(ny <= 0 || ny > N || nx <= 0 || nx > M) continue;

                if(map[ny][nx] == 0){
                    if(visited[temp.wall][ny][nx]) continue;
                    pq.add(new Node(ny, nx, temp.wall, temp.move+1));
                    visited[temp.wall][ny][nx] = true;
                }

                else {
                    if(temp.wall+1 > K) continue;
                    if(visited[temp.wall+1][ny][nx]) continue;
                    if((temp.move) % 2 == 0) {
                        pq.add(new Node(ny, nx, temp.wall + 1, temp.move + 2));
                        visited[temp.wall + 1][ny][nx] = true;
                    }
                    else {
                        pq.add(new Node(ny, nx, temp.wall + 1, temp.move + 1));
                        visited[temp.wall + 1][ny][nx] = true;
                    }
                }
            }
        }

        return -1;
    }
}

class Node{
    int x;
    int y;
    int wall;
    int move;
    Node(int y, int x, int wall, int move){
        this.y = y;
        this.x = x;
        this.wall = wall;
        this.move = move;
    }
}