package boj10039;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;

        for(int i = 0; i < 5; i++){
            int score = Integer.parseInt(br.readLine());
            sum += (score < 40 ? 40 : score);
        }

        bw.write((sum / 5) + "\n");

        bw.close();
        br.close();
    }
}
