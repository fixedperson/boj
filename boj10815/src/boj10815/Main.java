package boj10815;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while(N-- > 0){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-- > 0){
            if(hs.contains(Integer.parseInt(st.nextToken()))){
                sb.append("1 ");
            }
            else {
                sb.append("0 ");
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
