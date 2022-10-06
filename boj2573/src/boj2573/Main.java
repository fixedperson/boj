package boj2573;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> queue = new LinkedList<>();
    static boolean[][] visited;
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
                if(map[i][j] > 0) queue.add(new Node(i, j));
            }
        }

        int time = 0;
        while(true){
            if(!isChunk()) break;

            bfs();
            time++;
            if(queue.size() == 0) {
                System.out.println(0);
                System.exit(0);
            }
        }

        bw.write(time + "\n");

        br.close();
        bw.close();
    }
    static void bfs(){
        int size = queue.size();
        int[][] tempMap = new int[N][M];

        for(int i = 0 ; i < size; i++){
            Node temp = queue.poll();

            int count = isMelt(temp.x, temp.y);
            tempMap[temp.x][temp.y] = map[temp.x][temp.y] - count < 0 ? 0 : map[temp.x][temp.y] - count;

            if(tempMap[temp.x][temp.y] > 0) queue.add(temp);
        }

        map = tempMap;
    }
    static boolean isChunk(){
        visited = new boolean[N][M];

        Queue<Node> tempQ = new LinkedList<>();
        Node temp = queue.peek();
        tempQ.add(temp);
        visited[temp.x][temp.y] = true;
        while(!tempQ.isEmpty()){
            temp = tempQ.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                tempQ.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }

        Object[] qArr = queue.toArray();
        for(Object o : qArr){
            Node n = (Node) o;
            if(!visited[n.x][n.y]) return false;
        }

        return true;
    }
    static int isMelt(int x, int y){
        int count = 0;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isValid(x, y)) continue;
            if(map[nx][ny] == 0) count += 1;
        }

        return count;
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
