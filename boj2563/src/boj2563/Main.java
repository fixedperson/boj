package boj2563;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[100][100];
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x+10; i++){
                for(int j = y; j < y+10; j++){
                    visited[i][j] = true;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < 100; i++)
            for(int j = 0; j < 100; j++)
                if (visited[i][j]) answer++;

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }
}
