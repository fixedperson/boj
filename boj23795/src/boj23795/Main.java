package boj23795;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        while(true){
            int money = Integer.parseInt(br.readLine());
            if(money == -1) break;

            sum += money;
        }

        bw.write(String.valueOf(sum));

        bw.close();
        br.close();
    }
}
