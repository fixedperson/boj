package boj15680;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(N == 0 ? "YONSEI" : "Leading the Way to the Future"));

        bw.close();
        br.close();
    }
}
