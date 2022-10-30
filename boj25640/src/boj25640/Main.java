package boj25640;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mbti = br.readLine();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(N-- > 0){
            String temp = br.readLine();

            if(temp.equals(mbti)) cnt++;
        }

        bw.write(String.valueOf(cnt));

        bw.close();
        br.close();
    }
}
