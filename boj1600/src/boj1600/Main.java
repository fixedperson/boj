package boj1600;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1, -2, -1, 1, 2, -1, -2, 1, 2};
    static int[] dy = {-1, 0, 1, 0, -1, -2, -2, -1, 2, 1, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[H][W][K+1];

        bw.write(bfs() + "\n");

        br.close();
        bw.close();
    }
    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.x == H-1 && temp.y == W-1) return temp.time;

            for(int i = 0; i < 12; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(map[nx][ny] == 1) continue;

                // 말 능력
                if(i >= 4){
                    if(temp.horse == K) continue;
                    if(visited[nx][ny][temp.horse+1]) continue;

                    queue.add(new Node(nx, ny, temp.time+1, temp.horse+1));
                    visited[nx][ny][temp.horse+1] = true;
                }

                // 그 외
                else {
                    if(visited[nx][ny][temp.horse]) continue;

                    queue.add(new Node(nx, ny, temp.time+1, temp.horse));
                    visited[nx][ny][temp.horse] = true;
                }
            }
        }

        return -1;
    }
    static boolean isValid(int x, int y){
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}

class Node{
    int x, y, time, horse;

    Node(int x, int y, int time, int horse){
        this.x = x;
        this.y = y;
        this.time = time;
        this.horse = horse;
    }
}
