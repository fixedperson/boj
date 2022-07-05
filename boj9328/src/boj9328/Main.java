package boj9328;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static List<Point>[] list;
    static boolean[] key;
    static int h, w;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Point> queue;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            queue = new LinkedList<>();
            key = new boolean[26];
            count = 0;
            list = new List[26];
            for(int i = 0; i < 26; i++){
                list[i] = new ArrayList<Point>();
            }

            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h+2][w+2];
            visited = new boolean[h+2][w+2];
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for(int i = 1; i < h+1; i++){
                String s = br.readLine();
                for(int j = 1; j < w+1; j++){
                    map[i][j] = s.charAt(j-1);
                }
            }

            String s = br.readLine();
            if(!s.equals("0")) {
                for (int i = 0; i < s.length(); i++) {
                    key[s.charAt(i) - 'a'] = true;
                }
            }

            bfs();

            sb.append(count + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        queue.add(new Point(0,0));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Point temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];

                if(ny < 0 || ny >= h+2 || nx < 0 || nx >= w+2) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == '*') continue;
                if(map[ny][nx] - 'A' >= 0 && map[ny][nx] - 'A' < 26){
                    if(key[map[ny][nx] - 'A']){
                        map[ny][nx] = '.';
                        visited[ny][nx] = true;
                        queue.add(new Point(ny, nx));
                    }
                    else{
                        list[map[ny][nx] - 'A'].add(new Point(ny, nx));
                    }
                }
                else if (map[ny][nx] - 'a' >= 0 && map[ny][nx] - 'a' < 26){
                    key[map[ny][nx] - 'a'] = true;
                    visited[ny][nx] = true;
                    queue.add(new Point(ny, nx));

                    for(Point p : list[map[ny][nx] - 'a']) {
                        map[p.y][p.x] = '.';
                        visited[p.y][p.x] = true;
                        queue.add(p);
                    }
                }
                else if (map[ny][nx] == '$'){
                    count++;
                    visited[ny][nx] = true;
                    queue.add(new Point(ny, nx));
                }
                else {
                    visited[ny][nx] = true;
                    queue.add(new Point(ny, nx));
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}