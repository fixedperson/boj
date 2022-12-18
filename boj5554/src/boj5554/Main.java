package boj5554;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;

        for(int i = 0; i < 4; i++){
            sum += Integer.parseInt(br.readLine());
        }

        bw.write((sum/60) + "\n" + (sum%60));

        bw.close();
        br.close();
    }
}
