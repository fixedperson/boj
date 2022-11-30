package boj14670;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int R = Integer.parseInt(br.readLine());
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            for(int j = 0; j < size; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(map.containsKey(temp)) queue.add(map.get(temp));
                else break;
            }

            if(queue.size() == size) {
                for(Integer j : queue) sb.append(j).append(" ");
                sb.append("\n");
            }
            else {
                sb.append("YOU DIED").append("\n");
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
