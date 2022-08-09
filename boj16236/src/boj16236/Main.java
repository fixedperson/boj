package boj16236;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int sharkX;
    static int sharkY;
    static int sharkSize = 2;
    static int eatFish = 0;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int totalTime = 0;
    static boolean isEmptyMap = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sharkX = j;
                    sharkY = i;
                    map[i][j] = 0;
                }
            }
        }

        while(!isEmptyMap){
            bfs();
        }

        bw.write(totalTime + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.time == o2.time) {
                    if (o1.y == o2.y) {
                        return o1.x - o2.x;
                    }
                    return o1.y - o2.y;
                }
                return o1.time - o2.time;
            }
        });
        pq.add(new Point(sharkX, sharkY, 0));

        boolean[][] visited = new boolean[N][N];
        visited[sharkY][sharkX] = true;

        while(!pq.isEmpty()){
            Point temp = pq.poll();

            if(map[temp.y][temp.x] > 0 && sharkSize > map[temp.y][temp.x]){
                totalTime += temp.time;
                sharkX = temp.x;
                sharkY = temp.y;
                eatFish++;
                if(sharkSize == eatFish){
                    sharkSize++;
                    eatFish = 0;
                }
                map[temp.y][temp.x] = 0;

                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] > sharkSize) continue;

                pq.add(new Point(nx, ny, temp.time + 1));
                visited[ny][nx] = true;
            }
        }

        isEmptyMap = true;
    }
}

class Point{
    int x;
    int y;
    int time;
    Point(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}