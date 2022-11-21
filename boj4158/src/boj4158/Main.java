package boj4158;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            HashSet<Integer> set = new HashSet<>();

            while (N-- > 0) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int cnt = 0;
            while (M-- > 0) {
                if (set.contains(Integer.parseInt(br.readLine()))) cnt++;
            }

            bw.write(cnt + "\n");
        }

        bw.close();
        br.close();
    }
}
