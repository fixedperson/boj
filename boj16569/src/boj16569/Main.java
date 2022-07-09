package boj16569;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> volQ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int M, N, V;
    static int max_alt;
    static int max_time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        visited = new boolean[M+1][N+1];
        map = new int[M+1][N+1];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        volQ = new LinkedList<>();
        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            volQ.add(new Node(x,y,t));
            map[x][y] = -1;
        }

        bfs(X, Y);

        bw.write(max_alt + " " + max_time);
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(int X, int Y){
        Queue<Node> moveQ = new LinkedList<>();
        moveQ.add(new Node(X,Y, 0));
        visited[X][Y] = true;
        max_alt = map[X][Y];

        int time = 0;
        while(!moveQ.isEmpty()){
            int len = volQ.size();
            for(int i = 0; i < len; i++){
                Node temp = volQ.poll();

                if(temp.t > time){
                    volQ.add(temp);
                    continue;
                }

                else {
                    for(int k = 0; k < 4; k++){
                        int nx = temp.x + dx[k];
                        int ny = temp.y + dy[k];

                        if(nx <= 0 || nx > M || ny <= 0 || ny > N) continue;
                        if(visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        volQ.add(new Node(nx, ny, temp.t + 1));
                    }
                }
            }

            len = moveQ.size();
            for(int i = 0; i < len; i++){
                Node temp = moveQ.poll();

                for(int k = 0; k < 4; k++) {
                    int nx = temp.x + dx[k];
                    int ny = temp.y + dy[k];

                    if (nx <= 0 || nx > M || ny <= 0 || ny > N) continue;
                    if (visited[nx][ny]) continue;
                    if(map[nx][ny] == -1) continue;

                    if(map[nx][ny] > max_alt){
                        max_alt = map[nx][ny];
                        max_time = time + 1;
                    }
                    visited[nx][ny] = true;
                    moveQ.add(new Node(nx, ny, temp.t+1));
                }
            }
            time++;
        }
    }
}

class Node {
    int x;
    int y;
    int t;
    Node(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}