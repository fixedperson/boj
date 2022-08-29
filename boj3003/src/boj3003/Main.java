package boj3003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append((1 - Integer.parseInt(st.nextToken())) + " ");
        sb.append((1 - Integer.parseInt(st.nextToken())) + " ");
        sb.append((2 - Integer.parseInt(st.nextToken())) + " ");
        sb.append((2 - Integer.parseInt(st.nextToken())) + " ");
        sb.append((2 - Integer.parseInt(st.nextToken())) + " ");
        sb.append((8 - Integer.parseInt(st.nextToken())) + " ");

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
