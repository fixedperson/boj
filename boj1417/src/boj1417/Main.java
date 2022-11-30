package boj1417;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int A = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(N-- > 1){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while(!pq.isEmpty()){
            int temp = pq.poll();
            if(temp >= A){
                A++;
                cnt++;
                pq.add(temp-1);
            }
            else break;
        }

        bw.write(cnt + "\n");

        bw.close();
        br.close();
    }
}
