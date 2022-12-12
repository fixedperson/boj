package boj20492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((N/100 * 78) + " ");
        bw.write(((N/100 * 80)+(N/100*20)/100*78) + " ");

        bw.close();
        br.close();
    }
}
