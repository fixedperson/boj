package boj5532;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        A = (int) Math.ceil(A/(double)Integer.parseInt(br.readLine()));
        B = (int) Math.ceil(B/(double)Integer.parseInt(br.readLine()));

        L = L - Math.max(A, B);

        bw.write(L + "\n");

        bw.close();
        br.close();
    }
}
