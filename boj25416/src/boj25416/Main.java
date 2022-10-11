package boj25416;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x, y, move;

    Node(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }
}

public class Main {
    private static final int H = 5;
    private static final int W = 5;
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int bfs(int r, int c){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(map[nx][ny] == -1) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1) return temp.move+1;

                queue.add(new Node(nx, ny, temp.move+1));
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
    static boolean isValid(int x, int y) {return x >=0 && x < 5 && y >= 0 && y < 5;}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(bfs(r, c) + "\n");

        bw.close();
        br.close();
    }
}
