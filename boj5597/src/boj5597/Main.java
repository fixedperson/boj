package boj5597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] visited = new boolean[31];

        for(int i = 0; i < 28; i++){
            int temp = Integer.parseInt(br.readLine());

            visited[temp] = true;
        }

        for(int i = 1; i <= 30; i++){
            if(!visited[i]) bw.write(i + "\n");
        }

        bw.close();
        br.close();
    }
}
