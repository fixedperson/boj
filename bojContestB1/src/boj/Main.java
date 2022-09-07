package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int minIndex = 0;
        long minDistance = Long.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        long sx = Integer.parseInt(st.nextToken());
        long sy = Integer.parseInt(st.nextToken());
        long ex = Integer.parseInt(st.nextToken());
        long ey = Integer.parseInt(st.nextToken());

        for(int j = 1; j <= N; j++){
            int M = Integer.parseInt(br.readLine());

            long x = sx, y = sy, distance = 0;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());

                int nx = Integer.parseInt(st.nextToken());
                int ny = Integer.parseInt(st.nextToken());

                distance += (Math.abs(x - nx) + Math.abs(y - ny));
                x = nx;
                y = ny;
            }
            distance += (Math.abs(x - ex) + Math.abs(y - ey));

            if(minDistance > distance){
                minIndex = j;
                minDistance = distance;
            }
        }

        bw.write(minIndex + "\n");

        bw.close();
        br.close();
    }
}
