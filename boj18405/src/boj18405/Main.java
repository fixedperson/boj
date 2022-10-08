package boj18405;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.virus - o2.virus;
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) pq.add(new Node(i, j, map[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(bfs(s, x, y) + "\n");

        bw.close();
        br.close();
    }
    static int bfs(int s, int x, int y){
        int time = 0;

        Queue<Node> queue = new LinkedList<>();
        while(!pq.isEmpty()) queue.add(pq.poll());

        while(time < s){
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node temp = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] != 0) continue;

                    queue.add(new Node(nx, ny, temp.virus));
                    map[nx][ny] = temp.virus;
                }
            }

            time++;
        }

        return map[x-1][y-1];
    }
}

class Node{
    int x, y, virus;

    Node(int x, int y, int virus){
        this.x = x;
        this.y = y;
        this.virus = virus;
    }
}