package boj26068;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        while(N-- > 0){
            int temp = Integer.parseInt(br.readLine().substring(2));

            if(temp <= 90) answer++;
        }

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }
}
