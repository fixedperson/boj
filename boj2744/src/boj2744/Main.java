package boj2744;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }
            else {
                sb.append(Character.toUpperCase(c));
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
