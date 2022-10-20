package boj1245;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int count = 0;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return map[o2.x][o2.y] - map[o1.x][o1.y];
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new Node(i, j));
            }
        }

        visited = new boolean[N][M];
        dfs();

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
    static void dfs() {
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            if (visited[temp.x][temp.y]) continue;
            if (isPeak(temp.x, temp.y)) {
                bfs(temp.x, temp.y);
                count++;
            }
        }
    }
    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 8; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] <= map[temp.x][temp.y]){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    static boolean isPeak(int x, int y){
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isValid(nx, ny)) continue;
            if(map[x][y] < map[nx][ny]) return false;
        }
        return true;
    }
    static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}