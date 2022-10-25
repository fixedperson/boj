package boj19944;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N >= M){
            if(M==1 || M==2){
                bw.write("NEWBIE!");
            }
            else{
                bw.write("OLDBIE!");
            }
        }
        else {
            bw.write("TLE!");
        }

        bw.close();
        br.close();
    }
}
