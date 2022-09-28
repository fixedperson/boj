package boj4179;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static Queue<Node> playerQ = new LinkedList<>();
    static Queue<Node> fireQ = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J'){
                    playerQ.add(new Node(i, j));
                    visited[i][j] = true;
                }

                else if(map[i][j] == 'F'){
                    fireQ.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int answer = bfs();

        bw.write((answer == -1 ? "IMPOSSIBLE" : answer) + "\n");

        bw.close();
        br.close();
    }
    static int bfs(){
        int time = 0;

        while(!playerQ.isEmpty()){
            int size = fireQ.size();
            for(int i = 0; i < size; i++){
                Node temp = fireQ.poll();

                for(int k = 0; k < 4; k++) {
                    int nx = temp.x + dx[k];
                    int ny = temp.y + dy[k];

                    if(!isValid(nx, ny)) continue;
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny] == '#') continue;

                    fireQ.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = 'F';
                }
            }

            size = playerQ.size();
            for(int i = 0; i < size; i++){
                Node temp = playerQ.poll();

                for(int k = 0; k < 4; k++){
                    int nx = temp.x + dx[k];
                    int ny = temp.y + dy[k];

                    if(!isValid(nx, ny)) return time + 1;
                    if(visited[nx][ny]) continue;

                    if(map[nx][ny] == '.') {
                        playerQ.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            time++;
        }

        return -1;
    }
    static boolean isValid(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}

class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}