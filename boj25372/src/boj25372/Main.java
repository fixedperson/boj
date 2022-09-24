package boj25372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            String s = br.readLine();

            sb.append((s.length() >= 6)&&(s.length()<=9)?"yes" : "no");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
