package boj3055;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C;
    static Queue<Point> queueS;
    static Queue<Point> queueW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        queueS = new LinkedList<>();
        queueW = new LinkedList<>();

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') {
                    queueS.add(new Point(i, j, 0));
                }
                else if(map[i][j] == '*'){
                    queueW.add(new Point(i, j, 0));
                }
            }
        }

        int answer = bfs();

        if(answer == -1){
            bw.write("KAKTUS");
        }

        else{
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static int bfs(){
        while(!queueS.isEmpty()) {
            int len = queueW.size();
            for (int i = 0; i < len; i++) {
                Point temp = queueW.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;


                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        queueW.add(new Point(nx, ny, temp.min + 1));
                    }
                }
            }

            len = queueS.size();
            for (int i = 0; i < len; i++) {
                Point temp = queueS.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                    if(map[nx][ny] == 'D')
                        return temp.min+1;

                    else if(map[nx][ny] == '.') {
                        map[nx][ny] = 'S';
                        queueS.add(new Point(nx, ny, temp.min + 1));
                    }
                }
            }
        }
        return -1;
    }
}

class Point{
    int x;
    int y;
    int min;
    Point(int x, int y, int min){
        this.x = x;
        this.y = y;
        this.min = min;
    }
}