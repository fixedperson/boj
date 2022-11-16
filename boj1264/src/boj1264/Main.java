package boj1264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String s = br.readLine();

            if(s.equals("#")) break;

            int num = 0;
            s = s.toLowerCase();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') num++;
            }

            bw.write(num + "\n");
        }

        bw.close();
        br.close();
    }
}
