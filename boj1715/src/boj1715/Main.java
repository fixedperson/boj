package boj1715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(pq.size() > 1){
            int A = pq.poll();
            int B = pq.poll();

            sum += (A+B);
            pq.add(A+B);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
