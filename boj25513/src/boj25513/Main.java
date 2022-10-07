package boj25513;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        map = new int[5][5];
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[5][5][7];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(bfs(r, c) + "\n");

        bw.close();
        br.close();
    }
    static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, 1));
        visited[x][y][1] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(visited[nx][ny][temp.nextNum]) continue;
                if(map[nx][ny] == -1) continue;

                if(map[nx][ny] == temp.nextNum){
                    if(temp.nextNum == 6) return temp.move+1;

                    queue.add(new Node(nx, ny, temp.move+1, temp.nextNum+1));
                    visited[nx][ny][temp.nextNum] = true;
                    visited[nx][ny][temp.nextNum+1] = true;
                }

                else {
                    queue.add(new Node(nx, ny, temp.move+1, temp.nextNum));
                    visited[nx][ny][temp.nextNum] = true;
                }
            }
        }

        return -1;
    }
    static boolean isValid(int x, int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}

class Node{
    int x, y, move, nextNum;

    Node(int x, int y, int move, int nextNum){
        this.x = x;
        this.y = y;
        this.move = move;
        this.nextNum = nextNum;
    }
}