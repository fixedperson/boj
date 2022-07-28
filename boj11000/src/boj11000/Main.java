package boj11000;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lec[] list = new Lec[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            list[i] = new Lec(S, T);
        }

        Arrays.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(list[0].T);

        for(int i = 1; i < N; i++){
            if(pq.peek() <= list[i].S){
                pq.poll();
            }

            pq.offer(list[i].T);
        }

        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Lec implements Comparable<Lec> {
    int S;
    int T;
    Lec(int S, int T){
        this.S = S;
        this.T = T;
    }

    @Override
    public int compareTo(Lec o) {
        if(this.S == o.S){
            return this.T - o.T;
        }
        return this.S - o.S;
    }
}
