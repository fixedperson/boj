package boj3197;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Node L1, L2;
    static int[][] lake;
    static int[] parents;
    static int R, C;
    static boolean[][] visited;
    static int parentsNum = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    static Queue<Node> dayQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                char temp = s.charAt(j);
                if(temp == '.')
                    lake[i][j] = 0;
                else if(temp == 'L'){
                    if(L1 == null)
                        L1 = new Node(i, j);
                    else
                        L2 = new Node(i, j);
                }
                else {
                    lake[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(visited[i][j] || lake[i][j] != 0) continue;
                setBfs(i,j);
            }
        }

        parents = new int[parentsNum+1];
        for(int i = 1; i <= parentsNum; i++){
            parents[i] = i;
        }

        bw.write(dayBfs() + "\n");
        bw.flush();
        bw.close();
    }
    static void setBfs(int waterX, int waterY){
        Queue <Node> queue = new LinkedList<>();
        parentsNum++;
        lake[waterX][waterY] = parentsNum;
        queue.offer(new Node(waterX, waterY));
        visited[waterX][waterY] = true;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x < 0 || x >= R || y < 0 || y >= C) continue;
                if(visited[x][y]) continue;
                if(lake[x][y] == 0) {
                    queue.offer(new Node(x,y));
                    lake[x][y] = parentsNum;
                    visited[x][y] = true;
                }
            }
        }
    }
    static int dayBfs(){
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[R][C];
        int day = 0;

        if(isSameParent(lake[L1.x][L1.y], lake[L2.x][L2.y]))
            return day;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(lake[i][j] == -1) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                for(int k = 0; k < 4; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x < 0 || x >= R || y < 0 || y >= C) continue;
                    if(visited[x][y]) continue;
                    if(lake[x][y] == -1){
                        visited[x][y] = true;
                        queue.offer(new Node(x,y, lake[i][j]));
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            day++;
            int dayQ = queue.size(); // 하루당 진행되는 큐의 사이즈
            for (int i = 0; i < dayQ; i++) {
                Node temp = queue.poll();
                lake[temp.x][temp.y] = temp.parent;
                for (int k = 0; k < 4; k++) {
                    int x = temp.x + dx[k];
                    int y = temp.y + dy[k];
                    if (x < 0 || x >= R || y < 0 || y >= C) continue;
                    if (visited[x][y]) {
                        if(lake[x][y] == -1) continue;
                        union(lake[x][y], lake[temp.x][temp.y]);
                    } else {
                        visited[x][y] = true;
                        queue.offer(new Node(x, y, lake[temp.x][temp.y]));
                    }
                }
            }
            if(isSameParent(lake[L1.x][L1.y], lake[L2.x][L2.y]))
                return day;
        }
        return -1;
    }
    static int find(int x){
        if(x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x > y){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
        }
    }
    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y)
            return true;
        return false;
    }
}
class Node {
    int x;
    int y;
    int parent;
    Node(int x, int y, int parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}