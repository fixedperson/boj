package boj5524;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            String s = br.readLine();

            bw.write(s.toLowerCase() + "\n");
        }

        bw.close();
        br.close();
    }
}
