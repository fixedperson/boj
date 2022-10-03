package boj6593;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L,R,C;
    static char[][][] map;
    static boolean[][][] visited;
    static Queue<Node> queue;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0 ,0, 0 ,1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            queue = new LinkedList<>();
            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = s.charAt(k);

                        if (map[i][j][k] == 'S') {
                            queue.add(new Node(i, j, k, 0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            int answer = bfs();

            if(answer != -1){
                sb.append("Escaped in " + answer + " minute(s)." + "\n");
            }
            else {
                sb.append("Trapped!" + "\n");
            }
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
    static int bfs(){
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 6; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nz = temp.z + dz[i];

                if(!isVaild(nx, ny, nz)) continue;
                if(visited[nz][nx][ny]) continue;
                if(map[nz][nx][ny] == '#') continue;

                if(map[nz][nx][ny] == 'E') return temp.time+1;

                queue.add(new Node(nz, nx, ny, temp.time+1));
                visited[nz][nx][ny] = true;
            }
        }

        return -1;
    }
    static boolean isVaild(int x, int y, int z){
        return x >= 0 && x < R && y >= 0 && y < C && z >= 0 && z < L;
    }
}

class Node{
    int x, y, z, time;

    Node(int z, int x, int y, int time){
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }
}