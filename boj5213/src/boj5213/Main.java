package boj5213;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] tile;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Node ansTile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N*2];
        tile = new int[N][N*2];
        int cnt = 1;
        for(int i = 0; i < N; i++){
            if(i%2 == 0){
                for(int j = 0; j < N*2; j+=2){
                    st = new StringTokenizer(br.readLine());
                    map[i][j] = Integer.parseInt(st.nextToken());
                    map[i][j+1] = Integer.parseInt(st.nextToken());

                    tile[i][j] = cnt;
                    tile[i][j+1] = cnt;
                    cnt++;
                }
            }
            else {
                for(int j = 0; j < (N-1)*2; j+=2){
                    st = new StringTokenizer(br.readLine());
                    map[i][j+1] = Integer.parseInt(st.nextToken());
                    map[i][j+2] = Integer.parseInt(st.nextToken());

                    tile[i][j+1] = cnt;
                    tile[i][j+2] = cnt;
                    cnt++;
                }
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N*2; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        visited = new boolean[N][N*2];
        bfs();

        sb.append(ansTile.move + "\n");
        for(Integer i : ansTile.path){
            sb.append(i + " ");
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(tile[0][0]);
        queue.add(new Node(0, 0, 1, path));
        queue.add(new Node(0, 1, 1, path));
        visited[0][0] = true;
        visited[0][1] = true;
        ansTile = new Node(0, 0, 1, path);

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(tile[temp.x][temp.y] == N*N-N/2){
                ansTile = temp;
                return;
            }

            if(tile[ansTile.x][ansTile.y] < tile[temp.x][temp.y]){
                ansTile = temp;
            }

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(tile[nx][ny] == 0) continue;


                if(map[temp.x][temp.y] == map[nx][ny]){
                    path = new ArrayList<>();
                    path.addAll(temp.path);
                    path.add(tile[nx][ny]);
                    visited[nx][ny] = true;

                    queue.add(new Node(nx, ny, temp.move+1, path));

                    if(tile[nx][ny+1] == tile[nx][ny]) {
                        visited[nx][ny+1] = true;
                        queue.add(new Node(nx, ny+1, temp.move+1, path));
                    }
                    else if(tile[nx][ny-1] == tile[nx][ny]){
                        visited[nx][ny-1] = true;
                        queue.add(new Node(nx, ny-1, temp.move+1, path));
                    }
                }
            }
        }
    }
    static boolean isValid(int x, int y){
        return (x >= 0) && (x < N) && (y >= 0) && (y < N*2);
    }
}

class Node{
    int x,y;
    int move;
    ArrayList<Integer> path;
    Node(int x, int y, int move, ArrayList<Integer> path){
        this.x = x;
        this.y = y;
        this.move = move;
        this.path = path;
    }
}
