package boj1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < N; i++){
            hs.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < M; i++){
            String s = br.readLine();
            if(hs.contains(s)) list.add(s);
        }
        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for(String s : list){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
