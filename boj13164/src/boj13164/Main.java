package boj13164;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        int pre = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());

            pq.add(cur - pre);
            pre = cur;
        }

        long answer = 0;
        for(int i = 0; i < (N-K); i++){
            answer += pq.poll();
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
