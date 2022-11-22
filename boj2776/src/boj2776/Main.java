package boj2776;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        HashSet<Integer> set;
        while(T-- > 0){
            set = new HashSet<>();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(N-- > 0){
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(M-- > 0){
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? "1" : "0").append("\n");
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
