package boj17135;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] map;
    static int[][] temp;
    static boolean[][] visited;
    static int ans;
    static int maxAns = 0;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};
    static Queue<Node> attQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = (i+1); j < M; j++){
                for(int k = (j+1); k < M; k++){
                    temp = arrClone();
                    attQ = new LinkedList<>();
                    ans = 0;
                    while(!end()){
                        attack(i);
                        attack(j);
                        attack(k);
                        att();
                        temp = move();
                    }
                    maxAns = Math.max(maxAns, ans);
                }
            }
        }

        bw.write(maxAns + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int[][] arrClone(){
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = map[i][j];
            }
        }

        return arr;
    }
    static void attack(int i){
        visited = new boolean[N][M];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.time == o2.time){
                    return o1.y - o2.y;
                }
                return o1.time - o2.time;
            }
        });
        pq.add(new Node(N-1, i, 1));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.time > D) continue;

            if(temp[node.x][node.y] == 1){
                attQ.add(new Node(node.x, node.y, 0));
                return;
            }

            for(int l = 0; l < 3; l++){
                int nx = node.x + dx[l];
                int ny = node.y + dy[l];

                if (!isVaild(nx, ny)) continue;
                if (visited[nx][ny]) continue;


                pq.add(new Node(nx, ny, node.time+1));
                visited[nx][ny] = true;
            }
        }
    }
    static void att(){
        while(!attQ.isEmpty()){
            Node node = attQ.poll();

            if(temp[node.x][node.y] == 1){
                temp[node.x][node.y] = 0;
                ans++;
            }
        }
    }
    static int[][] move() {
        int[][] moveArr = new int[N][M];

        for(int i = 0; i < (N-1); i++){
            for(int j = 0; j < M; j++){
                moveArr[i+1][j] = temp[i][j];
            }
        }

        return moveArr;
    }
    static boolean end() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
    static boolean isVaild(int x, int y){
        return (x >= 0) && (x < N) && (y >= 0) && (y < M);
    }
}

class Node{
    int x, y, time;
    Node(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}