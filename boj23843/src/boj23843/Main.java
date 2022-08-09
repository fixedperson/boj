package boj23843;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < Math.min(M,N); i++){
            pq.offer(list.get(i));
        }

        for(int i = M; i < N; i++){
            int temp = pq.poll() + list.get(i);
            pq.offer(temp);
        }

        int size = pq.size();
        for(int i = 0; i < size-1; i++) pq.poll();

        bw.write(pq.poll() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
