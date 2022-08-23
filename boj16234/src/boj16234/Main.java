package boj16234;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[][] nextMap;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int day = 0;
    static boolean isMove;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][N];
            nextMap = new int[N][N];
            isMove = false;
            dfs();
            if(!isMove) break;
            map = nextMap;
            day++;
        }

        bw.write(day + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;

                bfs(i ,j);
            }
        }
    }
    static void bfs(int i, int j){
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Node(i, j));
        next.add(new Node(i, j));
        int totalPop = map[i][j];
        int totalCnt = 1;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int k = 0; k < 4; k++){
                int nx = temp.x + dx[k];
                int ny = temp.y + dy[k];

                if(!isValid(nx, ny)) continue;
                if(visited[nx][ny]) continue;

                int diff = Math.abs(map[nx][ny] - map[temp.x][temp.y]);
                if(diff >= L && diff <= R) {
                    isMove = true;
                    queue.add(new Node(nx, ny));
                    next.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    totalPop += map[nx][ny];
                    totalCnt++;
                }
            }
        }

        while(!next.isEmpty()){
            Node temp = next.poll();

            nextMap[temp.x][temp.y] = totalPop / totalCnt;
        }
    }
    static boolean isValid(int x, int y){
        return (x >= 0) && (x < N) && (y >= 0) && (y < N);
    }
}
class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}