package boj19238;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, fuel;
    static int[][] map;
    static boolean[][] visited;
    static int taxiX, taxiY;
    static HashMap<Integer, Node> pass = new HashMap<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean fail = false;
    static int success = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    map[i][j] = -1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken())-1;
        taxiY = Integer.parseInt(st.nextToken())-1;

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = i;

            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            pass.put(i, new Node(x, y));
        }

        for(int i = 0; i < M; i++){
            findPass();
            if(fail) break;
        }

        if(success != M) bw.write("-1");
        else bw.write(fuel + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void findPass() {
        visited = new boolean[N][N];
        if(map[taxiX][taxiY] > 0){
            Node des = pass.get(map[taxiX][taxiY]);
            map[taxiX][taxiY] = 0;
            runTaxi(des.x, des.y);
            return;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(taxiX, taxiY, 0));
        visited[taxiX][taxiY] = true;

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            if(map[temp.x][temp.y] > 0){
                taxiX = temp.x;
                taxiY = temp.y;
                fuel -= temp.move;
                if(fuel < 0){
                    fail = true;
                }
                else {
                    Node des = pass.get(map[temp.x][temp.y]);
                    map[temp.x][temp.y] = 0;
                    runTaxi(des.x, des.y);
                }
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(map[nx][ny] == -1) continue;
                if(visited[nx][ny]) continue;

                pq.add(new Node(nx, ny, temp.move + 1));
                visited[nx][ny] = true;
            }
        }
    }
    static void runTaxi(int desX, int desY) {
        visited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(taxiX, taxiY, 0));
        visited[taxiX][taxiY] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == -1) continue;

                if(nx == desX && ny == desY){
                    taxiX = nx;
                    taxiY = ny;
                    fuel -= (temp.move+1);
                    if(fuel < 0){
                        fail = true;
                        return;
                    }
                    fuel += (temp.move+1)*2;
                    success++;
                    return;
                }
                else {
                    queue.add(new Node(nx, ny, temp.move + 1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    static boolean isValid(int x, int y){
        return (x >= 0) && (x < N) && (y >= 0) && (y < N);
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int move;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Node(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }

    @Override
    public int compareTo(Node o) {
        if (this.move != o.move) {
            return this.move - o.move;
        } else {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }
}