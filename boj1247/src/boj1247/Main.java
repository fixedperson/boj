package boj1247;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++){
            int t = Integer.parseInt(br.readLine());

            BigInteger temp = new BigInteger("0");
            while(t-- > 0){
                temp = temp.add(new BigInteger(br.readLine()));
            }

            if(temp.equals(new BigInteger("0"))) sb.append(temp).append("\n");
            else sb.append(temp.compareTo(new BigInteger("0")) > 0 ? "+" : "-").append("\n");
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
