package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if((a - K) > (N - 1)){
            sb.append(N + " ");
        }
        else {
            sb.append((a - K + 1) + " ");
        }

        if((a - K) % M == 0){
            sb.append(((a - K) / M + 1));
        }
        else {
            sb.append(((a - K) / M + 2));
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
